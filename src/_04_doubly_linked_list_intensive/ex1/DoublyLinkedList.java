package _04_doubly_linked_list_intensive.ex1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoublyLinkedList<E> implements List<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private Node<E> findNode(int searchIndex) {
        // TODO : 찾는 노드의 index가 음수거나 노드의 개수 보다 많거나 같으면 예외를 발생시킨다.
        if (0 > searchIndex || size < searchIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int nodeIndex;
        Node<E> pointer;
        if (size / 2 > searchIndex) {
            // TODO : 앞에서부터 찾는다.
            nodeIndex = 0;
            pointer = head;
            while (nodeIndex != searchIndex) {
                ++nodeIndex;
                pointer = pointer.right;
            }
        } else {
            // TODO : 뒤에서부터 찾는다.
            nodeIndex = size - 1;
            pointer = tail;
            while (nodeIndex != searchIndex) {
                --nodeIndex;
                pointer = pointer.left;
            }
        }
        return pointer;
    }

    @Override
    public void add(int index, E data) {
        // TODO : 노드의 순서를 기준으로 해당 index에 삽입한다. (밀어넣기)
        Node<E> node = new Node<>();
        node.data = data;

        // TODO : 최초 노드 삽입 또는 맨 앞 또는 맨 뒤에 노드를 삽입하는 경우
        if (0 == index || size == index) {
            if (null == this.head && null == this.tail) {
                // TODO : 최초 노드 삽입
                this.head = node;
                this.tail = node;
            } else if (0 == index) {
                // TODO : 맨 앞에 노드를 삽입
                node.right = this.head;
                this.head.left = node;
                this.head = node;
            } else {
                // TODO : 맨 뒤에 노드를 삽입
                node.left = this.tail;
                this.tail.right = node;
                this.tail = node;
            }
        } else {
            // TODO : 해당 index에 삽입하려면 해당 노드를 찾아야 한다.
            Node<E> foundNode = findNode(index);
            Node<E> leftNode = foundNode.left;
            // TODO : 새로운 노드와 찾은 노드의 연결
            node.right = foundNode;
            foundNode.left = node;
            // TODO : 새로운 노드와 이전 노드의 연결
            node.left = leftNode;
            leftNode.right = node;
        }
        ++size;
    }

    private E removeNode(Node<E> removeNode) {
        // TODO : 해당하는 Node를 삭제한다.

        Node<E> leftNode = removeNode.left;
        Node<E> rightNode = removeNode.right;
        E data = removeNode.data;

        if (null != leftNode) {
            // TODO : 좌측 노드가 존재하는 경우
            leftNode.right = rightNode;
        }
        if (null != rightNode) {
            rightNode.left = leftNode;
        }
        if (null == leftNode) {
            // TODO : 맨 앞에 있는 노드 삭제 시 (index가 아니더라도 leftNode가 null이면 맨 앞에 있는 노드로 볼 수 있다)
            this.head = rightNode;
        }
        if (null == rightNode) {
            // TODO : 맨 뒤에 있는 노드 삭제 시 (index가 아니더라도 rightNode가 null이면 맨 뒤에 있는 노드로 볼 수 있다)
            this.tail = leftNode;
        }
        // TODO : 삭제할 노드의 링크를 모두 끊는다.
        removeNode.left = null;
        removeNode.right = null;
        removeNode.data = null;

        --size;
        return data;
    }

    @Override
    public E remove(int index) {
        // TODO : 해당 index에 해당하는 Node를 삭제한다.
        Node<E> removeNode = findNode(index);
        return removeNode(removeNode);
    }

    public E removeFirst() {
        // TODO : 맨 앞의 노드를 삭제
        return remove(0);
    }

    public E removeLast() {
        // TODO : 맨 뒤의 노드를 삭제
        return remove(size - 1);
    }

    public void addFirst(E data) {
        // TODO : 맨 앞에 노드를 추가
        add(0, data);
    }

    public void addLast(E data) {
        // TODO : 맨 뒤에 노드를 추가
        add(size, data);
    }

    @Override
    public boolean isEmpty() {
        // TODO : 노드가 비어있는지 확인하는 메서드
        return 0 == size;
    }

    @Override
    public boolean contains(Object data) {
        // TODO : 이중 연결 리스트에 해당 데이터가 포함되어 있는지 확인한다.
        return indexOf(data) != -1;
    }

    @Override
    public boolean add(E data) {
        // TODO : 맨 뒤의 노드를 추가하여 데이터를 삽입한다.
        try {
            add(size, data);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object data) {
        // TODO : 매개변수로 전달 받는 데이터를 가지고 있는 노드를 제거한다.
        Node<E> pointer = head;

        while (null != pointer) {
            if (null == data && null == pointer.data) {
                removeNode(pointer);
                return true;
            } else if (null != data && data.equals(pointer.data)) {
                removeNode(pointer);
                return true;
            }
            pointer = pointer.right;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        // TODO : 맨 뒤에 Collection에 해당하는 노드를 삽입한다.
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        // TODO : index를 기준으로 index 이후로부터 노드를 삽입한다.
        if (0 > index || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] array = collection.toArray();
        if (0 == array.length) {
            return false;
        }
        for (Object data : array) {
            @SuppressWarnings("unchecked") E tempData = (E) data;
            add(index, tempData);
            ++index;
        }
        return true;
    }

    @Override
    public void clear() {
        // TODO : 모든 노드의 링크를 끊는다.
        Node<E> pointer = head;

        while (null != pointer) {
            // TODO : 미리 우측 노드를 저장해 두고 링크를 끊어야만 참조값을 잃어버리지 않는다.
            Node<E> rightNode = pointer.right;
            pointer.data = null;
            pointer.right = null;
            pointer.left = null;
            pointer = rightNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        // TODO : index에 해당하는 노드의 데이터를 반환한다.
        return findNode(index).data;
    }

    public E set(int index, E data) {
        // TODO : index에 해당하는 기존 노드의 데이터를 변경한다. (덮어쓰기)
        Node<E> foundNode = findNode(index);
        foundNode.data = data;
        return data;
    }

    @Override
    public boolean retainAll(Collection collection) {
        // TODO : 교집합 구하기
        if (null == collection) {
            throw new NullPointerException();
        }
        boolean modified = false;
        Node<E> pointer = head;

        while (null != pointer) {
            // TODO : pointer가 가리키는 노드를 삭제(removeNode)하면 rightLink의 연결이
            // TODO : null이 되기 떄문에 우측 노드의 참조값을 잃어버리므로, 미리 참조값을 저장한다.
            Node<E> tempRightNode = pointer.right;
            if (!collection.contains(pointer.data)) {
                this.removeNode(pointer);
                modified = true;
            }
            pointer = tempRightNode;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection collection) {
        // TODO : 여집합 구하기
        if (null == collection) {
            throw new NullPointerException();
        }
        boolean modified = false;
        Node<E> pointer = head;

        while (null != pointer) {
            // TODO : pointer가 가리키는 노드를 삭제(removeNode)하면 rightLink.의 연결이
            // TODO : null이 되기 때문에 우측 노드의 참조값을 잃어버리므로, 미리 참조값을 저장한다.
            Node<E> tempRightNode = pointer.right;
            if (collection.contains(pointer.data)) {
                this.removeNode(pointer);
                modified = true;
            }
            pointer = tempRightNode;
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection collection) {
        // TODO : 노드에 collection이 포함하는 데이터를 모두 가지고 있는지 확인한다.
        for (Object data : collection) {
            if (!contains(data)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO : fromIndex부터 toIndex까지 데이터를 가진 list 반환
        // TODO : 구현상 편의를 위해 AbstractList를 상속 받는 ArrayList로 반환한다.
        if (fromIndex > toIndex || size < fromIndex || size <= toIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int index = fromIndex;
        List<E> list = new ArrayList<>(size);
        Node<E> pointer = findNode(fromIndex);

        while (null != pointer && index - 1 != toIndex) {
            list.add(pointer.data);
            pointer = pointer.right;
            ++index;
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        // TODO : 노드의 데이터를 배열로 반환
        Object[] result = new Object[size];
        int index = 0;
        Node<E> pointer = head;

        while (null != pointer) {
            result[index++] = pointer.data;
            pointer = pointer.right;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            array = (T[]) java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = array;
        for (Node<E> x = head; x != null; x = x.right) {
            result[i++] = x.data;
        }

        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    @Override
    public int size() {
        // TODO : 노드의 개수를 반환하는 메서드
        return size;
    }

    @Override
    public int indexOf(Object data) {
        // TODO : 앞에서부터 검색
        int index = 0;
        Node<E> pointer = head;

        while (null != pointer) {
            if (null == data && null == pointer.data) {
                // TODO : 찾는 데이터도 null이고 노드에 저장된 데이터도 null이면
                return index;
            } else if (null != data && data.equals(pointer.data)) {
                // TODO : 찾는 데이터가 null이 아니고 노드에 저장된 데이터와 동일하면
                return index;
            }
            pointer = pointer.right;
            ++index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object data) {
        // TODO : 뒤에서부터 검색
        int index = size - 1;
        Node<E> pointer = tail;

        while (null != pointer) {
            if (null == data && null == pointer.data) {
                // TODO : 찾는 데이터도 null이고 노드에 저장된 데이터도 null이면
                return index;
            } else if (null != data && data.equals(pointer.data)) {
                // TODO : 찾는 데이터도 null이 아니고 노드에 저장된 데이터도 null이 아니면
                return index;
            }
            pointer = pointer.left;
            --index;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO : 생략 ^^
        throw new RuntimeException("DoublyLinkedList에서 미구현입니다.");
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO : 생략 ^^
        throw new RuntimeException("DoublyLinkedList에서 미구현입니다.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO : 생략 ^^
        throw new RuntimeException("DoublyLinkedList에서 미구현입니다.");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.right;
        }
        stringBuilder.append("null ");
        if (null != tail) {
            stringBuilder.append(", tail(").append(tail.data).append("), ");
        }
        pointer = tail;
        stringBuilder.append("tail").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.left;
        }
        stringBuilder.append("null");
        if (null != head) {
            stringBuilder.append(", head(").append(head.data).append(")");
        }
        return stringBuilder.toString();
    }

}
