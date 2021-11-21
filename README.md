# Array vs LinkedList

## Array

`Array`는 가장 기본적인 자료 구조 중 하나로, 논리적 저장 순서와 물리적 저장 순서가 동일한 특징을 갖는다.
따라서 `인덱스(index)` 로 각각의 원소(element)에 접근할 수 있다. 이러한 특성 덕분에 찾고자 하는 원소의 인덱스 값만 알고 있다면 Big-O(1) 만에 해당 원소에 접근할 수 있다. 즉, **Random access**가 가능하다는 장점이 있다는 것이다.

그러나 삽입, 삭제 과정에서는 해당 원소에 접근하여 작업을 완료한 이후(O(1)) 추가적인 비용(cost)이 발생한다. 예를 들어, 삭제한 원소의 인덱스 보다 큰 인덱스를 갖는 원소들을 `shift` 해줘야 하는데, 이 경우의 최악의 시간 복잡도는 O(n)이 된다.

또한, Array는 생성할 때 크기를 할당해 주어야 한다. 따라서 사용하지 않는 메모리 공간까지도 미리 계획하여 메모리를 할당 해야 하고, 공간이 부족한 경우 확장을 위한 비용이 추가된다는 점은 단점으로 작용한다. 배열에 빈 공간이 없는 상태에서 원소를 삽입해야 하는 경우, 기존 배열 크기의 2배인 배열 공간을 만들고 기존의 데이터를 옮기는 작업을 진행해야 하기 때문에 이런 경우 삽입은 O(n)의 시간 복잡도를 갖게 된다.

#### Time Complexity

|    **연산**     | 평균 | 최악 |
| :-------------: | :--: | :--: |
|  접근(Access)   | O(1) | O(1) |
|  탐색(Search)   | O(n) | O(n) |
| 삽입(Insertion) | O(1) | O(n) |
| 삭제(Deletion)  | O(1) | O(n) |

**1. 접근(Access) : O(1)**  
-index를 알고 있다면 특정 원소에 바로 접근이 가능.

**2. 탐색(Search) : O(n)**  
-index를 모르는 상태에서 특정 값의 존재를 확인하거나, 특정 값의 index를 확인하는 경우.

**3. 삽입(Insertion) : O(1) / O(n)**  
-배열 공간이 충분한 상태에서 가장 뒤에 삽입하는 경우는 O(1)  
-가장 앞에 삽입하는 경우는 O(n)  
-배열 공간의 확장이 필요한 경우는 O(n)

**4. 삭제(Deletion) : O(1) / O(n)**  
-가장 뒤쪽 원소를 삭제하는 경우는 O(1)  
-가장 앞쪽 원소를 삭제하는 경우는 O(n)

## Linked List

`Linked List`는 데이터와 참조값을 갖는 노드들이 한 줄로 연결 되어 있는 방식으로 데이터를 저장하는 자료 구조이다.
따라서 삽입(삭제) 시에는 노드를 생성(삭제)하고 연결(연결 해제)만 해주면 되기 때문에 단순한 삽입(삭제)의 시간 복잡도는 O(1)이 된다.

그러나 Linked List는 Array와 달리 index가 존재하지 않기 때문에 문제점이 있다. 한 줄로 연결 되어 있는 Linked List의 구조적인 특징 때문에 특정 노드를 탐색(Search)하기 위해서는 노드들을 순차적으로 이동하며 탐색을 하게 된다. 따라서 탐색 동작의 경우, 시간 복잡도는 O(n)이다.

결국 Linked List에서 삽입과 삭제를 진행할 때, 해당 노드를 탐색하는 연산이 추가적으로 발생하기 때문에 삽입, 삭제 시 최종적인 시간 복잡도는 O(n)이 된다.

Linked List의 공간적인 특징으로는 Array와 달리 크기가 가변적이라는 것이다. 데이터를 삽입할 때 노드를 생성하기 때문에 런타임 환경에서도 가변 배열처럼 사용할 수 있고, 때문에 메모리를 상대적으로 절약할 수 있다.

Linked List는 한 줄로 연결된 구조이지만 노드 간의 연결을 다양화함으로써 `Tree` 구조의 근간으로 활용되며, Tree에서 Linked List의 특징이 더욱 강력하게 발휘된다.

#### Time Complexity

|         **연산**         | 평균 | 최악 |
| :----------------------: | :--: | :--: |
| 접근/탐색(Access/Search) | O(n) | O(n) |
|     삽입(Insertion)      | O(1) | O(n) |
|      삭제(Deletion)      | O(1) | O(n) |

**1. 접근/탐색(Access/Search) : O(n)**  
-특정 위치의 원소에 바로 접근이 불가능하여 리스트를 순회하는 것이 필연적.

**2. 삽입(Insertion) : O(1) / O(n)**  
-맨 앞, 맨 뒤에 삽입하는 경우는 O(1)  
-중간 삽입을 위해 탐색을 해야 하는 경우는 O(n)

**3. 삭제(Deletion) : O(1) / O(n)**  
-맨 앞, 맨 뒤의 원소를 삭제하는 경우는 O(1)  
-중간 삭제를 위해 탐색을 해야 하는 경우는 O(n)
<br>

##### Implementation Practice

- [Singly Linked List 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_01_singly_linked_list/SinglyLinkedList.java)
- [Doubly Linked List 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_04_doubly_linked_list_intensive/ex1/DoublyLinkedList.java)

<hr>

# Stack and Queue

## Stack

`Stack`은 선형 구조를 갖는 자료 구조로서, 데이터의 삽입과 삭제가 한 쪽 끝에서만 가능하다. 입구와 출구가 동일한 상자와 같은 구조로 인해 마지막에 들어간 데이터가 가장 먼저 나오는 `후입선출(LIFO - Last In First Out)`의 특징을 갖는다.  
Stack에서는 데이터를 넣는 것을 `Push`, 꺼내는 것을 `Pop`, 마지막 위치(`top`)의 데이터를 읽는 것을 `Peek`이라고 한다.

Stack은 `DFS(Depth First Search; 깊이 우선 탐색)`, `후위 연산`, `괄호 유효성 검사` 등에서 사용되며, `뒤로 가기`, `되돌리기` 등에도 활용된다.

#### Time Complexity

|    **연산**     | 평균 | 최악 |
| :-------------: | :--: | :--: |
|  탐색(Search)   | O(1) | O(n) |
| 삽입(Insertion) | O(1) | O(1) |
| 삭제(Deletion)  | O(1) | O(1) |

**1. 탐색(Search) : O(n)**  
-맨 위에 삽입된 데이터를 찾는 경우는 O(1)  
-중간에 삽입된 데이터를 찾는 경우는 O(n)

**2. 삽입(Insertion) : O(1)**

**3. 삭제(Deletion) : O(1)**

## Queue

`Queue` 또한 선형 구조를 갖는 자료 구조이며, Stack과는 달리 먼저 들어간 데이터가 먼저 나오는 `선입선출(FIFO - First In First Out)`의 특징을 갖는다. Queue를 구현하는 방법으로는 크게 Array를 활용한 `Circlular Queue`와 LinkedList를 활용한 Queue가 있다.  
Queue에서는 꺼낼 데이터를 `front`를 통해 알 수 있으며, 가장 마지막에 삽입된 데이터는 `rear`를 통해 알 수 있다. 또한, 데이터를 삽입하는 것을 `Add`, 꺼내는 것을 `Poll`이라고 한다.

`Java Collection`에서 Queue는 `Interface`이기 때문에, queue를 사용하기 위해서는 이를 구현하고 있는 `Priority queue` 등을 사용해야 한다. Queue는 `BFS(Breath First Search; 너비 우선 탐색)` 등에 사용되며, 일반적으로 `작업 대기열`로 많이 사용된다.  
`Thread Pool`에서 작업을 저장하는 데에도 큐가 사용되어 먼저 들어온 작업을 순차적으로 처리할 수 있도록 한다. 또한 메시지와 관련한 서버 간 통신을 위해 사용되는 `메시지 큐`라는 것도 있고, `시스템 버퍼`에서도 사용되는 등 수많은 곳에서 활용되고 있다.

#### Time Complexity

|    **연산**     | 평균 |
| :-------------: | :--: |
|  탐색(Search)   | O(n) |
| 삽입(Insertion) | O(1) |
| 삭제(Deletion)  | O(1) |

<br>

##### Implementation Practice

- [Array Stack 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_05_array_stack/ArrayStack.java)
- [Linked List Stack 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_06_list_stack/ListStack.java)
- [Circular Queue 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_07_circle_queue/CircleQueue.java)
- [Linked List Queue 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_08_list_queue/ListQueue.java)

<hr>

# Tree

`Tree`의 정의는 `사이클이 없는 무방향 연결 그래프`이다.  
사이클은 '경로'에 한 노드가 두 번 이상 포함되는 것을 의미하며, 사이클이 없다는 것은 '경로'가 순환하지 않는다는 것을 의미한다. 연결 그래프란, 그래프 상의 모든 노드들이 '연결'되어 있다는 것으로 모든 노드 사이에 '경로'가 존재함을 의미한다.

#### Tree를 구성하는 요소 및 용어 정리

- Ndoe (노드) : 키(key) 또는 값(value) 또는 데이터(data)를 갖고 있는 트리 집합의 원소
- Edge (간선) : 트리를 구성하기 위해 노드와 노드를 연결하는 선
- Root Node (루트 노드) : 최상위 노드로서 아래로 여러 후손(descendant) 노드들이 존재
- Terminal Node (= Leaf Node; 단말 노드 = 잎사귀 노드) : 트리를 구성하는 노드들 중에서 하위 노드(자식 노드)가 없는 노드
- Internal Node (= Non-Terminal Node; 내부 노드 = 비단말 노드) : 트리를 구성하는 노드들 중에서 Leaf Node가 아닌 노드
- Parent Node (부모 노드) : 어떤 노드의 상위 노드
- Child Node (자식 노드) : 어떤 노드의 하위 노드
- Sibling Node (형제 노드) : 부모가 같은 노드
- SubTree (서브 트리) : 특정 노드를 기준으로 아래에 있는 트리를 말하며, 서브 트리는 자식 노드의 수 만큼 분리됨
- Degree (차수) : 어떤 노드의 자식 수, 즉 서브 트리의 개수
- Depth (깊이) : 루트 노드를 기준으로 특정 노드까지의 간선의 수
- Level (레벨) : 루트 노드를 Level 0으로 하여, 트리의 특정 깊이를 가지는 노드의 집합
- Height (높이) : 트리의 최대 Level

#### Tree의 특징

1. 위에서 아래로 향하는 계층 구조를 갖는다.
2. 루트(root) 노드를 가지고 있다.
3. 부모(parent) 노드는 하나이다.
4. 노드들끼리의 연결을 간선(edge)이라고 한다.

### Binary Tree (이진 트리)

루트 노드가 최대 두 개의 서브 트리를 가지며, 각각의 서브 트리 또한 모두 이진 트리를 이루는 트리를 말한다.  
재귀적으로 정의되어 있어 공집합도 이진 트리에 포함된다. 루트 노드에서부터 재귀적으로 이진 트리 조건을 확인하며 서브 트리를 타고 내려가다가, 리프 노드에 도달했을 때에도 정의를 만족하기 위해서는 공집합도 이진 트리 조건에 포함되어야 하기 때문이다.

#### Perfect Binary Tree (포화 이진 트리)

모든 내부 노드가 두 개의 자식을 가진 노드이며, 모든 리프 노드가 동일한 레벨을 가지고 있는 이진 트리. 즉, 모든 레벨이 꽉 차있는 이진 트리.

#### Full Binary Tree (정 이진 트리)

모든 노드가 0개 혹은 2개의 자식 노드만 갖는 이진 트리. 즉, 모든 내부 노드가 두 개의 자식을 가진 노드이며, 모든 리프 노드가 동일한 레벨을 가지고 있지 않아도 된다.

#### Complete Binary Tree (완전 이진 트리)

마지막 레벨을 제외한 모든 레벨이 두 개의 자식 노드를 가지고 있으며, 마지막 레벨의 모든 노드들이 왼쪽부터 채워져 있는 이진 트리.  
참고로 완전 이진 트리를 구현하는 경우, 배열을 활용하는 것이 가장 좋다. 왜냐하면, 노드의 개수가 n개일 때, i번째 노드에 대해 parent(i) = i / 2, left_child(i) = 2i, right_child(i) = 2i + 1의 index를 갖기 때문이다. 이러한 특징은 `Heap`이라는 자료 구조를 구현할 때 용이하게 활용할 수 있다.
<br>

##### Implementation Practice

- [Binary Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_12_normal_binary_tree/NormalTree.java)
- [Binary Tree Traversal(DFS) 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_13_binary_tree_DFS/NormalTree.java)
- [Binary Tree Traversal(BFS) 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_14_binary_tree_BFS/NormalTree.java)

## Binary Search Tree (BST; 이진 탐색 트리)

#### 배열 또는 리스트 방식 탐색 구조의 단점

트리 구조를 사용하는 일반적인 이유는 데이터를 빠르게 찾기 위한 탐색 구조가 필요하기 때문. 배열 또는 리스트 방식의 탐색 구조는 앞이나 뒤에서부터 원하는 데이터를 찾을 때까지 순차적으로 탐색을 해야만 한다. 이런 경우, 최악의 상황에서는 전체 데이터의 수(n) 만큼 탐색하게 된다. 이는 데이터가 많아질수록 탐색에 걸리는 시간이 더욱 길어지는 단점으로 작용한다.  
그러나 이진 탐색 트리 구조에서는 원하는 데이터를 빠르게 찾기 위한 특정한 규칙을 적용하여 자료 구조를 구성한다.

#### Binary Search Tree

`Binary Search Tree(BST)`는 이름에서 알 수 있듯이 `Search`에 최적화된 `이진 트리`이다. BST는 빠른 탐색을 위해 다음과 같은 특정한 규칙들을 만족하도록 데이터를 저장한다.

- 규칙 1. 이진 탐색 트리의 노드에 저장된 키는 유일하다.
- 규칙 2. 부모 노드의 키 > 왼쪽 자식 노드의 키
- 규칙 3. 부모 노드의 키 < 오른쪽 자식 노드의 키
- 규칙 4. 왼쪽과 오른쪽 서브 트리도 이진 탐색 트리이다.

#### Time Complexity

|    **연산**     |   평균   | 최악 |
| :-------------: | :------: | :--: |
|  탐색(Search)   | O(log n) | O(n) |
| 삽입(Insertion) | O(log n) | O(n) |
| 삭제(Deletion)  | O(log n) | O(n) |

**1. 탐색(Search) : O(log n) / O(n)**  
-루트 노드에서부터 높이가 하나씩 늘어날수록 노드의 수는 2배씩 증가하기 때문에 평균 시간 복잡도는 O(h) = O(log n)
-BST가 `Skewed Tree(편향 트리)`로 만들어진 경우, 최악의 시간 복잡도가 되어 O(n)

**2. 삽입(Insertion) : O(log n) / O(n)**  
-삽입 연산 또한 탐색 기반으로 동작하기 때문에 시간 복잡도는 탐색과 동일.

**3. 삭제(Deletion) : O(log n) / O(n)**  
-삭제 연산 또한 탐색 기반으로 동작하기 때문에 시간 복잡도는 탐색과 동일.

BST에서 발생하는 이런 문제점들로 인해 `Rebalancing` 기법이 고안 되었다. `Rebalancing`은 트리의 높이를 조정하는 기법으로, 트리가 편향되지 않도록 특정한 규칙에 따라 균형을 잡아주어 평균 시간 복잡도와 최악의 시간 복잡도가 모두 `O(log n)`이 되도록 만든다. 이런 기법을 구현한 트리는 대표적으로 `AVL Tree(Adelson-Velsky And Landis Tree)`, `Red-Black Tree`, `B-Tree(Balanced Tree)`가 있다.
<br>

##### Implementation Practice

- [Binary Search Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_15_binary_search_tree/BinarySearchTree.java)
- [AVL Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_16_avl_tree/AVLTree.java)
- [Red-Black Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_17_red_black_tree/RedBlackTree.java)
- [B-Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_19_b_tree/BTree.java)

## Binary Heap

#### Heap

`Heap`은 트리에 기반한 특별한 자료 구조로 우선 순위가 높은 데이터가 부모로 배치되고, 우선 순위가 낮은 데이터가 자식으로 배치되는 관계를 가지고 있다. 또한, Heap에는 `Binary Heap`, `Fibonacci Heap` 등이 존재하며, Heap의 특징을 이용해 `Priority Queue`, `Heap Sort` 등을 구현할 수 있다.

#### Binary Heap

`Binary Heap`은 `Complete Binary Tree`의 구조를 가지고 있으며, 데이터 삽입 및 삭제 시 우선 순위에 따라 트리의 노드를 재배치하는 과정을 거친다. 이러한 Binary Heap의 종류로는 `Max Heap(최대힙)`과 `Min Heap(최소힙)`이 있다.

#### Binary Heap의 특징

1. 자식보다 부모의 우선 순위가 더 높다.
2. Complete Binary Tree의 특징을 가지고 있다.
3. 형제 간에는 우선 순위가 존재하지 않는다.
4. 루트 노드는 우선 순위가 가장 높은 데이터를 가지고 있다.

이러한 특징들로 인해 **Binary Heap은 최댓값을 찾거나 최솟값을 찾는 데에 특화**되어 있으며, 그것이 각각 `Max Heap`과 `Min Heap`이다. `Java Collection`에서 Heap의 구현체로는 `Priority Queue`가 있다.

Max Heap은 **각 노드의 데이터가 자식 노드의 데이터보다 크거나 같은 Complete Binary Tree**이다. Complete Binary Tree의 특징 덕분에 Heap 역시 배열로 구현하는 것이 좋다. Max Heap은 항상 Root Node에 있는 값이 가장 크기 때문에 최댓값 탐색 시 시간 복잡도는 O(1)이 된다. 데이터를 삽입하는 경우, 삽입하는 노드는 Heap의 가장 마지막 노드로 삽입되며 Heap의 성질을 만족하도록 하기 위해 부모 노드의 우선 순위와 비교하여 부모 노드의 우선 순위보다 높으면 `swap`하는 방식으로 제 자리를 찾아 위로 올라간다(`UpHeap`). 데이터를 삭제하는 경우, Heap의 가장 마지막 노드를 Root로 대체시키고 새로운 Root는 Heap의 성질을 만족하도록 제 자리를 찾아 내려간다(`DownHeap`). 이렇게 Heap의 구조를 유지하기 위해 노드를 재위치시키는 것을 `힙 생성 알고리즘`이라고 하며, `Heapify`라고도 부른다. 이러한 Heapify 연산의 시간 복잡도는 O(log n)이 되기 때문에 삽입과 삭제 연산의 시간 복잡도는 O(log n)이 된다.

#### Binary Heap에서의 데이터 삽입

1. 노드를 맨 마지막 Leaf 노드로 삽입한다.
2. 부모 노드의 우선 순위가 삽입된 노드보다 높을 때까지 Swap한다. (UpHeap)

#### Binary Heap에서의 데이터 삭제

1. Root 노드를 맨 마지막 Leaf 노드와 Swap한다.
2. Swap된 Leaf 노드를 삭제한다.
3. 새로운 Root 노드를 자식 노드의 우선 순위와 비교하되 자식 중에서 더 우선 순위가 높은 자식 노드와 Swap하고, 자식 노드의 우선 순위가 낮을 때까지 Swap한다. (DownHeap)

#### Time Complexity

|    **연산**     |   평균   |   최악   |
| :-------------: | :------: | :------: |
|  탐색(Search)   |   O(1)   |   O(1)   |
| 삽입(Insertion) | O(log n) | O(log n) |
| 삭제(Deletion)  | O(log n) | O(log n) |

**1. 탐색(Search) : O(1)**  
-최댓값(최솟값) 탐색 시 O(1)

**2. 삽입(Insertion) : O(log n)**  
-Heapify 연산의 시간 복잡도 O(log n)

**3. 삭제(Deletion) : O(log n)**  
-Heapify 연산의 시간 복잡도 O(log n)
<br>

##### Implementation Practice

- [Max Heap 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_18_binary_heap/MaxHeap.java)
- [Min Heap 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_18_binary_heap/MinHeap.java)

<hr>

# Hash Table

`Hash Table`은 `key`와 `value`의 구조를 가진 데이터를 저장하는 자료 구조로, `Hash Function(해시 함수)`을 이용하여 key를 `Hash Value(해시값)`으로 변환하여 Hash value를 `Index`로 사용하는 것이 특징이다. `Hash Table`은 `Associated Array`, `Dictionary`, `Symbol Table`로 불리기도 한다.

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kr60q1yd.png)
[이미지 출처 - 코드 라떼](https://www.codelatte.io/)

Hash Table은 해시 함수를 이용하는 특성 때문에 해시값이 중복되는 `Hash Collision(해시 충돌)`이 발생할 수 있다. **서로 다른 key들이 해시 함수를 통해 동일한 해시값으로 변환되는 것을 해시 충돌**이라고 한다. 따라서 좋은 해시 함수는 충돌 가능성을 낮추는 함수이다. 해시값의 중복을 최소화하기 위해서는 해시값을 최대한 고르게 분포시킬 수 있는 함수를 만들어야 하며, 충돌 발생 시 어떻게 처리하는지에 따라 Hash Table의 성능이 달라지게 된다.

### Hash Table의 구성

#### Hash Function(해시 함수)

`Hash Function`은 임의의 길이의 데이터를 고정된 길이의 데이터로 `Mapping`하는 함수이다. 일반적으로 domain이 codomain보다 크기 때문에 비둘기집의 원리에 의해 반드시 충돌쌍이 발생하게 된다. `Hash Collision`이 많아질수록 Search 동작의 시간 복잡도는 O(1)에서 O(n)에 수렴하게 된다. 그렇기 때문에 어설픈 Hash Function을 사용하는 것은 Hash를 Hash 답지 않게 만드는 것이므로, 좋은 성능의 Hash Table을 위해서는 좋은 Hash Fucntion을 만들어야만 한다.  
Hashing 된 Index에 이미 다른 값이 들어 있는 경우, 추가하고자 하는 데이터를 저장할 다른 인덱스를 찾아야 한다. Hash Table을 사용하기 위해서는 이렇게 충돌 발생을 해결하기 위한 방법은 필수적이며, 이를 위해 `Supplement Hash Function(보조 해시 함수)`를 이용하거나 동일한 Hash value를 갖는 데이터들을 `Linked List`로 연결하여 저장하는 등의 방식을 활용할 수 있다.

#### Bucket(버킷)

`Bucket`은 해시값을 인덱스로 하여 데이터에 접근할 수 있는 배열을 말한다. 배열 접근의 시간 복잡도는 O(1)이므로 인덱스의 위치에 찾고자 하는 키가 존재한다면 가장 빠르게 찾을 수 있다. 그러나 Hash Collision의 발생 빈도가 커질수록 시간 복잡도는 증가하게 된다.

#### Entry(엔트리)

Hash Table은 key와 value를 저장하는 구조이므로 노드를 이용하여 key와 value를 저장할 수 있다. 이렇게 key와 value를 저장하는 노드를 `Entry`라고 한다.

<br>

## How To Resolve the Hash Collision

충돌 발생 시 이에 대응하기 위한 방법으로는 크게 `Separate Chaining(체이닝; 분리 연결)`과 `Open-Addressing(직접 주소 개방)`이 있다.

### Open-Addressing(직접 주소 개방)

`Open-Addressng` 방식은 bucket에 key가 1:1로 저장되는 방식으로 Chaining과 달리 Hash Table 외부에 연결된 노드가 존재하지 않는다. 따라서 이미 동일한 해시값으로 Hash Table에 키가 저장되어 있는 경우에는 `보조 해시 함수(Supplement Hash Function)`에 의해 빈 공간을 조사(Probing)하여 키를 저장한다. 즉, Hash Collision이 발생하면 다른 비어있는 bucket을 데이터를 저장하는 것이다. 만약 빈 공간이 존재하지 않을 경우, key를 저장할 수 없으며 Hash Table의 적재율을 체크하여 bucket의 크기를 확장할 수 있다. 이러한 `Open-Addressing` 방식은 대표적으로 `Linear Probing`, `Quadratic Probing`, `Double Hashing Probing` 세 가지 방법이 있으며, 보조 해시 함수의 형태에 따른 분류라고도 이해할 수 있다.

#### Linear Probing

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kr60qq7z.png)
[이미지 출처 - 코드 라떼](https://www.codelatte.io/)

**`Linear Probing`은 이름 그대로 선형적인 특성을 가지고 있는 해시 함수를 이용하여 조사하는 방식**을 말한다. key를 찾거나, 삽입할 위치를 찾거나, 삭제할 키를 찾을 때 순차적으로 접근하는 방식을 택한다. 즉, **충돌이 발생하면 bucket index를 1씩 늘려가면서 조사**를 하는 방식이다.  
Linear Probing은 결국 키의 충돌이 빈번할수록 키의 분포가 특정 영역에 군집되는 현상을 겪는다. 탐색의 특성 상 키를 찾거나 빈 공간을 만날 때까지 탐색하는데, 군집으로 인해 빈 공간이 존재하지 않는 경우 탐색 횟수가 많아져 성능이 떨어질 수 밖에 없다. 또한, 충돌이 발생하면 다른 위치에 key를 저장하게 되기 때문에 key를 삭제하는 경우 본래 hash value에 따라 재배치를 진행해야 한다. 이때 원활한 재배치를 위해서는 `Dummy Null Entry`를 삽입해야 하는데, 이러한 방식을 `Lazy Deletion`이라고 한다.

> **Linear Probing에서의 Hash Function**  
> h(key, i) = (h'(key) + i) mod m (m is size of hash table)

#### Time Complexity of Linear Probing

|    **연산**     | 평균 | 최악 |
| :-------------: | :--: | :--: |
|  탐색(Search)   | O(1) | O(n) |
| 삽입(Insertion) | O(1) | O(n) |
| 삭제(Deletion)  | O(1) | O(n) |

<br>

#### Quadratic Probing

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kr60qzjx.png)
[이미지 출처 - 코드 라떼](https://www.codelatte.io/)

Quadratic Probing은 Linear Probing과 유사하나 보조 상수 c1, c2를 추가하여 non-linear하게 조사하는 방식이다. 이미지에서 보여지듯, 최초 조사를 시작할 때 i를 1씩 증가 시키는 것은 Linear Porbing과 동일하나, 보조 해시 함수를 c1, c2를 계수로 하는 i에 대한 2차 함수 형태로 갖는다. 이때 계수 c1, c2 값을 통해 충돌 키들이 군집되는 현상을 어느 정도 완화할 수 있으므로 적절한 c1, c2 값을 정해야 한다.

> **Quadratic Probing에서의 Hash Function**  
> h(key, i) = (h'(key) + (c1 \* i) + (c2 \* i²)) mod m (m is size of hash table)

<br>

#### Double Hashing Probing

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kr60r9m2.png)
[이미지 출처 - 코드 라떼](https://www.codelatte.io/)

`Double Hashing`은 군집 문제를 완화하기 위해 두 개의 보조 해시 함수를 이용하여 최대한 균등하게 분포하도록 하는 방법이다. 최초 조사를 시작할 때 i를 1씩 증가시키되, h2(key) 보조 해시 함수에 의해 두 번째 탐색 위치가 달라진다. Double Hashing은 Quadratic Probing 방식보다 좀 더 가벼운 군집 문제를 겪는다.

> **Double Hashing Probing에서의 Hash Function**  
> h(key, i) = (h1(key) + (i \* h2(key)) mod m (m is size of hash table)

<br>

##### Implementation Practice

- [Linear Probing Hash Table 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_20_open_adressing_hash_table/linear/LinearProbingHashTable.java)
- [Quadratic Probing Hash Table 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_16_avl_tree/AVLTree.java)

<hr>

### Chaining(체이닝)

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kr60qbu5.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

**`Chaining`은 `key-value` 삽입 시 동일한 hash value가 존재하는 경우에 노드를 연결하여 저장하는 방식**이다. key의 개수가 bucket의 크기보다 큰 경우 Hash Table의 적재율이 100%를 넘어갈 수 있다. 또한 노드 간의 연결이 많을 경우 Search 동작에 걸리는 시간 복잡도가 늘어날 수 있다. 예를 들어, 3번 index에 100개의 노드가 연결되어 있고 찾고자 하는 key가 3번 index에 있다면 최악의 경우 시간 복잡도는 O(100)이 될 수 있는 것이다. 따라서 이 문제를 완화하기 위한 방법으로 적재율에 따라 bucket의 크기를 늘리거나 노드 간 연결을 `Linear Structure`가 아닌 `Non-Linear Structure`로 변경할 수 있다.

#### Linked List를 이용한 방식

각 노드들을 Linear하게 연결하는 것으로 각각의 bucket들을 Linked List로 만들어 Collision이 발생하면 해당 bucket의 list에 추가하는 방식이다. Linked List의 특징을 그대로 이어 받아 삽입과 삭제가 간단하다. 하지만 단점 역시도 그대로 적용 되기 때문에 데이터 저장 시 Linked List 자체의 오버헤드가 부담이 된다. 또한, Collision의 빈도가 많아 bucket의 특정 index에 key가 몰리는 경우 Search에 걸리는 시간 복잡도가 O(n)에 수렴하게 되는 것은 피할 수 없다. 삽입과 삭제 시에도 탐색의 과정이 필요하기 때문에 같은 문제가 발생한다. 그러나 bucket 만을 사용하는 Open-Addressing 방식과 비교하면 테이블의 확장을 늦출 수는 있다.

#### Time Complexity

|    **연산**     | 평균 | 최악 |
| :-------------: | :--: | :--: |
|  탐색(Search)   | O(1) | O(n) |
| 삽입(Insertion) | O(1) | O(n) |
| 삭제(Deletion)  | O(1) | O(n) |

<br>

##### Implementation Practice

- [Chaining Hash Table 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_21_chaining_hash_table/ChainingHashTable.java)

<br>

#### Tree를 이용하는 방식 (Red-Black Tree)

Linked List를 이용한 Chaining과 원리는 같으나, Linked List를 사용하지 않고 Tree 구조를 사용하는 `Non-Linear` 방식이다.`Java Collection`의 `Hash Map`에서는 `Red-Black Tree`를 사용하고 있다. 때문에 Search의 시간 복잡도를 `O(log n)`으로 만들 수 있는 `Red-Black Tree`의 장점으로 데이터의 양이 많은 상황에서 발생하는 성능 이슈를 해소할 수 있다.  
다만, 완벽한 자료 구조라는 것은 존재하지 않기 때문에 `Trade-Off`를 해야 하는 부분이 있다. 일반적인 Linked List보다 Red-Black Tree의 노드에 더 많은 변수가 선언되어 있기 때문에 더 많은 메모리를 소모한다. 또한 Red-Black Tree는 균형을 잡기 위한 재배치 연산으로 인해 키의 삽입/삭제 성능이 떨어질 수 있다.

그렇기 때문에 **충돌된 키 개수의 임계치에 따라서 구조를 바꾸는 전략**을 취할 수 있다. 충돌된 키의 개수가 적을 경우에는 Linked List를 사용하고, 충돌된 키의 개수가 많을 경우에는 Red-Black Tree를 사용하는 것이다. 충돌이 빈번하지 않은 경우는 Linked List의 장점을 극대화 하고, 충돌이 빈번한 경우는 Tree로 변경하면 된다. 이러한 방법은 **실제로 Java Collection의 Hash Map을 구현하고 있는 방법**이다.

|    **연산**     | 평균 |   최악   |
| :-------------: | :--: | :------: |
|  탐색(Search)   | O(1) | O(log n) |
| 삽입(Insertion) | O(1) | O(log n) |
| 삭제(Deletion)  | O(1) | O(log n) |

<br>

#### 구조를 변경하는 충돌 키 개수의 임계치

**Java Collection의 Hash Map에 적용된 entry 간의 연결 구조를 변환하는 기준은 하나의 bucket에 할당된 key-value 쌍의 개수**이다. 즉, 충돌 키의 개수를 기준으로 하며 같은 **bucket index를 갖는 key-value 쌍의 개수가 6개, 8개 일 경우에 구조를 변경**한다. 충돌키의 개수가 6개인 경우 Linked List와 Tree 모두 Search에 걸리는 평균 시간 복잡도는 O(3)일 것이다. 그러나 8개가 되면서부터 Linked List와 Tree의 평균 시간 복잡도는 각각 O(4), O(3)으로 차이가 벌어지며, 이 차이는 충돌 key-value 쌍의 수가 많아질수록 더 커지게 된다. 그렇기 때문에 충돌 키가 증가하여 8개가 되는 순간 Red-Black Tree로 구조를 변경하는 것이 유리한 것이다.

그렇다면 키 삭제가 일어나 충돌 키가 8개 미만으로 감소하는 경우에는 어떨까? 시간 복잡도만을 놓고 본다면 충돌 키 개수가 7개가 되는 순간 Linked List로 변환을 해야 할 것이다. 그러나 실제 기준은 6개로 하고 있는데, 그 이유는 Tree 구조에서 Linked List 구조로 변환하는 과정에서도 `Switching cost`가 크기 때문이다. 만약 키의 삽입과 삭제가 빈번하여, 충돌 키의 증감이 반복되는 경우 구조 변경으로 인한 비용이 오히려 역효과를 가져오기 때문에 **Tree에서 Linked List로 변환하는 데에는 2개의 margin을 두어 6개를 기준**으로 한다.

<hr>

### Open-Addressing vs Separate Chaining

두 가지 방식 모두 Worst Case에서의 Time Complexity는 O(n)이다. 그러나 Open-Addressing 방식은 연속된 공간에 데이터를 저장하기 때문에 Chaining에 비해 Cache 효율이 높다. 따라서 데이터의 개수가 충분히 적은 경우에는 Open-Addressing이 Chaining 보다 더 성능이 좋다. 단, Open-Addressing은 Chaining과 달리 bucket을 계속해서 사용하기 때문에 Hash Table의 확장은 더욱 빠르다.

### Hash Bucket의 동적 확장(Resize)

Hash bucket의 크기가 작다면 그만큼 메모리 사용을 줄일 수 있지만, 해시 충돌로 인해 성능 상의 손실이 발생한다. 그래서 Hash Map은 key-value 쌍 데이터가 일정 수준 이상 적재되면 bucket의 크기를 두 배로 늘린다. 이렇게 bucket size를 확장하게 되면 해시 충돌로 인한 성능 손실 문제를 어느 정도 해결할 수 있다. 이때 **bucket을 확장하는 임계점은 bucket 내 데이터 적재율이 75%가 되는 때이다. 이 임계점을 나타내는 숫자 0.75는 `Load Factor`라고 부른다.**

<br>

##### Implementation Practice (Hash Table Using Singly Linked List and Red-Black Tree)

Collection Library HashMap의 개념을 적용한 Hash Table 구현 연습

- [Node 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_22_hash_table_using_red_black_tree/Node.java)
- [Singly Linked List 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_22_hash_table_using_red_black_tree/SinglyLinkedList.java)
- [Tree Node 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_22_hash_table_using_red_black_tree/TreeNode.java)
- [Red-Black Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_22_hash_table_using_red_black_tree/RedBlackTree.java)
- [Hash Table 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_22_hash_table_using_red_black_tree/CLHashTable.java)

<hr>

# Graph

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgbfwd.png)
![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgbolg.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

`Graph`는 `Vertex(정점)`과 vertex를 연결하는 `Edge(간선)`의 집합으로 구성된 자료 구조를 말한다. 그래프는 `G=(V,E)`로 표기하는데 V는 Vertex의 집합이고 E는 Edge의 집합이다. 그리고 vertex u는 vertex의 집합에 속해 있으며(u ∈ V), edge(u,v)는 edge의 집합에 속해있다((u,v) ∈ E).

> cf) Node와 Edge로 이루어진 Tree도 그래프의 일종이며, 사이클이 존재하지 않는 무방향 연결 그래프를 말한다.

<br>

## Complete Graph(완전 그래프)

**모든 정점끼리 간선으로 연결되어 있는 그래프**를 `완전 그래프`라고 한다. 각 정점들은 모든 정점으로 연결되어 있는 간선을 가지고 있으며 하나라도 누락되어 있다면 완전 그래프가 아니다.
<br>

## Undirected Graph and Directed Graph

### Undirected Graph(무방향 그래프)

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgca5h.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

`Undirected Graph(무방향 그래프)`는 **방향이 없는 간선을 가지고 양방향으로 진행**할 수 있으며, 무방향 그래프의 간선은 (u1, v2), (u2, v2)로 표현할 수 있다.

### Directed Graph(방향 그래프)

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgctnb.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

`Directed Graph(방향 그래프)`는 **방향이 있는 간선을 가지며, 각 간선은 한 방향으로만 진행**할 수 있다. 방향 그래프의 간선은 <u1, v2>, <u2, v2>로 표현할 수 있다.
<br>

## Degree of Vertex(정점의 차수)

정점에 접한 간선의 수를 Degree(차수)라고 한다.

### 무방향 그래프의 차수

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgdbzo.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

특정 정점을 기준으로 연결된 간선의 개수
<br>

### 방향 그래프의 차수

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgdwpw.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

`In-degree` : 특정 정점을 기준으로 안으로 들어오는 방향의 간선의 개수
`Out-degree` : 특정 정점을 기준으로 밖으로 나가는 방향의 간선의 개수
**Degree = In-degree + Out-degree**
<br>

## Path(경로)

**정점 u로부터 정점 v까지의 정점의 순서열**을 `경로`라고 한다. 간선 (v1, v2), (v2, v3), (v3, v4)가 존재할 때 v1, v2 v3를 말한다.

### Simple Path(단순 경로)

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgfagq.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

`Simple Path(단순 경로)`는 **한 경로 상에 있는 모든 정점들이 서로 다른 경우**를 말한다. 다만 단순 경로에서 시작 정점과 마지막 정점은 동일할 수 있다. 예시로 2, 0, 1, 2는 단순 경로이지만 2, 0, 1, 2, 3은 단순 경로가 아니다.

### Cycle(순환)

**출발지와 도착지가 같은 단순 경로**를 `Cycle(순환)`이라고 한다.
<br>

## Weight Graph(가중치 그래프)

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshgfxc7.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

**간선에 가중치가 있는 그래프**를 `Weight Graph(가중치 그래프)`라고 한다. 간선에 가중치가 존재한다면 특정 경로의 간선의 길이는 가중치의 합으로 계산한다.
<br>

## Graph vs Tree

|           |                            **그래프**                             |                        트리                         |
| :-------: | :---------------------------------------------------------------: | :-------------------------------------------------: |
|   정의    |            정점(Vertex)과 간선(Edge)로 구성된 자료구조            |              무방향 비순환 연결 그래프              |
|   모델    |                             네트워크                              |                        계층                         |
| 정점/노드 | 루트 노드가 존재하지 않으며 부모와 자식 간의 관계가 존재하지 않음 | 루트 노드가 존재하며 부모와 자식 간의 관계가 형성됨 |
|   간선    |          간선이 존재할 수도 있고 존재하지 않을 수도 있음          |    N개의 노드가 있으면 항상 N-1개의 간선이 존재     |
|   방향    |                    방향 그래프, 무방향 그래프                     |                    무방향 그래프                    |

<hr>

## 그래프의 구현 방법

![image](https://d1lic7t7i99g4n.cloudfront.net/photo/kshh6xev.png)
[이미지 출처 - 코드라떼](https://www.codelatte.io/)

그래프를 자료 구조로 표현하는 방법으로는 크게 `Adjacency-Matrix(인접 행렬)` 방식과 `Adjacency-List(인접 리스트)` 방식이 있다.

### Adjacency-Matrix(인접 행렬)

그래프를 `Adjacency-Matrix(인접 행렬)`로 표현할 경우 **간선의 개수와 상관 없이 정점의 개수|V|에 따라 O(V^2) 메모리 공간이 필요**하다. **Space Complexity = O(V^2)**. 예시로 정점의 개수가 8개인 경우 64개의 공간이 필요하다. 그러므로 정점의 수가 많을수록 더 많은 메모리가 필요하다. Adjacency-matrix는 `Dense graph`를 표현할 때 적절한 방법이다.

### Adjacency-List(인접 리스트)

그래프를 `Adjacency-List(인접 리스트)`로 표현할 경우 정점(V)의 개수와 간선(E)의 개수 만큼만 메모리 공간을 소모하기 때문에 O(V+E) 메모리 공간이 필요하다. **Space Complexity = O(V+E)**. Adjacency-List는 `Sparse graph`를 표현할 때 적절한 방법이다.

<br>

##### Implementation Practice

- [Adjacency-Matrix Graph 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_23_graph/adjacency_matrix_graph/AdjacencyMatrixGraph.java)
- [Adjacency-List Graph 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_23_graph/adjacency_list_graph/AdjacencyListGraph.java)

<hr>

## Graph Traversal - DFS & BFS

그래프는 정점의 구성 뿐 아니라 간선의 연결에도 규칙이 존재하지 않기 때문에 탐색이 복잡하다. 따라서 그래프의 모든 정점을 탐색하기 위한 두 가지 알고리즘을 활용할 수 있는데, 바로 `DFS(Depth First Search, 깊이 우선 탐색)`와 `BFS(Breadth First Search, 너비 우선 탐색)`이다.

### Depth First Search(DFS, 깊이 우선 탐색)

`DFS`는 **그래프 상에 존재하는 임의의 한 정점으로부터 연결되어 있는 다른 하나의 정점으로 나아가는 탐색 방법**이다. 시작 정점으로부터 연결된 다른 하나의 정점으로 나아가고, 다시 도착한 정점으로부터 연결된 또 다른 정점으로 나아가는 방식으로 더 이상 연결된 새로운 정점이 없을 때까지 탐색한다. 이때 한 번 방문한 정점은 방문 체크를 하여 중복 방문하지 않도록 해야 한다. 만약 더 이상 연결된 정점이 없다면, 바로 이전 분기점으로 돌아가서 방문하지 않은 새로운 정점을 탐색한다.  
하나의 정점에서 출발하여 더 이상 연결된 정점이 없을 때까지 나아가며 탐색하는 방식이기 때문에 Depth를 우선적으로 탐색한다는 의미로 DFS라고 부른다. **DFS는 Stack 자료 구조를 활용하여 구현**할 수 있으며, **Time Complexity는 O(V+E)이다.**

### Breadth First Search(BFS, 너비 우선 탐색)

`BFS`는 **그래프 상에 존재하는 임의의 한 정점으로부터 연결되어 있는 모든 정점으로 나아가는 탐색 방법**이다. Tree에서 Level Order Travaersal과 같은 방법으로 볼 수 있다. **BFS 구현은 Queue 자료 구조를 활용**하는데, 방문할 정점의 순서를 기억하기 위함이다. 먼저, 탐색을 시작하는 정점을 Queue에 삽입(add)하고, poll을 하여 해당 정점과 연결된 정점들을 Queue에 삽입하고 방문 체크를 한다. 이후, 동일한 방법으로 탐색을 진행하면 되는데 Queue에서 꺼낸(poll) 정점과 연결된 정점들 중 방문하지 않은 정점들만 Queue에 삽입(add)하면 된다. 이런 반복 연산을 Queue가 비워질 때까지 진행하면 모든 정점을 방문할 수 있게 된다.
하나의 정점에서 나아갈 수 있는 모든 정점들을 탐색하고, 탐색한 정점의 순서대로 다시 나아갈 수 있는 정점들을 탐색하는 방식이기 때문에 Breadth를 우선적으로 탐색한다는 의미로 BFS라고 부른다. 즉, 시작 정점으로부터 같은 Depth를 갖는 정점들을 모두 탐색한 후, 그 다음 Depth에 위치한 정점들을 탐색하는 것이다. **BFS의 Time Complexity도 O(V+E)이지만, BFS의 탐색 경로는 `최단 경로`가 된다는 특징**이 있다.

<br>

##### Implementation Practice

- [Adjacency-Matrix Graph로 DFS & BFS 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_24_graph_traversal_dfs_and_bfs/adjacency_matrix_graph/AdjacencyMatrixGraph.java)
- [Adjacency-List Graph로 DFS & BFS 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_24_graph_traversal_dfs_and_bfs/adjacency_list_graph/AdjacencyListGraph.java)

<hr>

## Minimum Spanning Tree(최소 신장 트리)

### Spanning Tree(신장 트리)

`Spanning Tree(신장 트리)`는 **Cycle(순환) 없이 모든 정점을 연결하는 그래프**를 말한다.

### Minimum Spanning Tree(최소 신장 트리)

`Minimum Spanning Tree(최소 신장 트리)`는 **모든 정점을 Cycle(순환) 없이 최소 간선 비용으로 모든 정점을 연결하는 그래프**를 말한다. 즉, Spanning Tree 중에서 Edge Weight의 합이 최소인 Spanning Tree가 Minimum Spanning Tree이다. 이런한 Minimum Spanning Tree를 만들 수 있는 대표적인 알고리즘으로는 `Kruskal's Algorithm`, `Prim's Algorithm`이 있다.

<br>

##### Implementation Practice

- [Kruskal's Algorithm을 이용한 Minimum Spanning Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_25_minimum_spanning_tree/kruskal_algorithm/Graph.java)
- [Prim's Algorithm을 이용한 Minimum Spanning Tree 구현](https://github.com/elegantstar/Data-Structure-in-Java/blob/master/src/_25_minimum_spanning_tree/prim_algorithm/Graph.java)
