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
