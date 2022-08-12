package ss8_list.bai_tap.array_list.model;

import java.util.Arrays;

public class MyArrayList<E> {
    // Số lượng phần tử trong MyArrayList
    private int size = 0;
    // Sức chứa của MyArrayList
    private static final int DEFAULT_CAPACITY = 10;
    // Mảng chứa các phần tử
    public Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //Constructor với sức chứa do ng dùng nhập vào
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity" + capacity);
        }
    }
    //Xóa hết phần tử trong mảng
    public void remove() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    //Thêm 1 element vào vị trí index của ArrayList
    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        } else if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }
    //Phương thức add phần tử vào mảng
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }
    //Phương thức tăng kích thước của ArrayList
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity " + minCapacity);
        }
    }
    //Phương thức trả về số lượng phần tử
    public int size() {
        return this.size;
    }
    // Lấy element tại 1 vị trí
    public E get(int index){
        return (E) elements[index];
    }
    // Lấy vị trí của phần tử trong mảng
    public int indexOf(E element){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return index;
    }
    // Phương thức kiểm tra element có trong ArrayList k?
    public boolean contains(E element){
        return this.indexOf(element) >=0;
    }
    // Sao chép ArrayList
    public MyArrayList<E> clone(){
        MyArrayList<E> v = new MyArrayList<>();
        v.elements = Arrays.copyOf(elements,size);
        v.size = this.size;
        return  v;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
