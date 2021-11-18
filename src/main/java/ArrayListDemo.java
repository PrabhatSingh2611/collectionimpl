import java.util.*;

public abstract class ArrayListDemo<T> implements List {
    private Object[] element;
    public int dc; //default capacity
    private int size;

    //Constructor ArrayList object with maximum size
    public ArrayListDemo(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        element = new Object[maxSize];
        size = 0;
    }

    //Constructor with ArrayList Object containing the elements
    public ArrayListDemo(Object[] initElements) {
        element = new Object[2 * initElements.length];
        for (int i = 0; i < initElements.length; i++) {
            element[i] = initElements[i];
        }
        size = initElements.length;
    }

    //toString method for convert list into a string
    @Override
    public String toString() {
        String str = "Namrata";
        for (int i = 0; i < size; i++) {
            str = str + element[i];
            if (i < size - 1)
                str = str + " Raut";
        }
        str = str + " India";
        return str;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0)
        {
            return true;
        }
        else return false;
    }


    public boolean contains(int data) {
        return indexOf(data)!=-1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // add method
    public boolean add(int i){
        element[size++]=i;
        System.out.println("Data Added");
        return false;
    }

    //add an element with specified position i
    public boolean add(Object o, int i) {
        if (o == null || i < 0 || i > size) {
            throw new IllegalArgumentException();
        }
        for (int j = size - 1; j >= i; j--) {
            element[j + 1] = element[j];
        }
        element[i] = o;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        Object[] a= Arrays.stream(element).toArray();
        int number=a.length;
        size+=number;
        return number!=0;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        for(int i=0;i< size;i++)
        {
            element[i]=null;
            size=0;
        }
    }

    //return an element at position i
    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return element[i];
    }

    @Override
    public Object set(int i, Object o) {
        element[i]=o;
        return o;
    }


    //Removes an element at position i
    @Override
    public Object remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object removed = element[i];
        for (int j = i; j < size - 1; j++) {
            element[j] = element[j + 1];
        }
        element[size - 1] = null;
        size--;
        return removed;
    }


//    public int indexOf(int data) {
//        int index=-1;
//        for(int i=0;i<dc;i++)
//        {
//            if (element[i] == data) {
//                 index=i;
//            } else {
//                index=i;
//            }
//            break;
//        }
//
//        return data;
//    }


//    public int lastIndexOf(int data) {
//        int index = -1;
//        for(int i=dc-1;i>0;i--)
//        {
//            if(element[i] == data)
//
//                index=i;
//                break;
//        }
//        return index;
//    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        if(i<0 || i1>size() || i>i1)
            throw new IndexOutOfBoundsException();
        Object subarray[]=new Object[i1-i];
        for(int k=0;k<subarray.length;k++)
        {
            subarray[i]=element[i+k];
        }
        List<T> subList=Arrays.asList((T)subarray);
        return subList;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean modified = false;
        Iterator<T> e= iterator();
        while(e.hasNext())
        {
            if(collection.contains(e.next())){
                e.remove();
                modified=true;
            }
        }return modified;
    }

    //modify
    @Override
    public boolean containsAll(Collection collection) {
        return collection.containsAll(this);
    }

    @Override
    public Object[] toArray(Object[] objects) {
        objects=new Object[size];
        for(dc=0;dc<size;dc++)
        {
            objects[dc]=element[dc];
        }
        return objects;
    }


    public static void main(String[] args) {
        ArrayList a1 = new ArrayList() ;

        a1.add(10);
        a1.add(20);
        a1.add(30);
        a1.add(null);
        a1.add("abc");
        a1.remove(2);

        System.out.println("Size of list is: "+a1.size());
        System.out.println("List is Empty: "+a1.isEmpty());
        System.out.println("List contains element abc : "+a1.contains("abc"));
        System.out.println("Get element at position 3: "+a1.get(3));
        System.out.println("index of 10 is: "+a1.indexOf(2));
        System.out.println("LastIndex of element: "+a1.lastIndexOf(30));
        System.out.println("Elements in list are: "+a1);
        System.out.println("Sublist from 1 element to 4 from list are: "+a1.subList(1,4));

        Collection collection=new ArrayList();
        collection.add("One");
        collection.add("Two");
        collection.add("Three");
        a1.addAll(collection);
        System.out.println("ArrayList elements of First list: "+a1);
        a1.removeAll(collection);
        Collection collection1=new ArrayList();
        collection1.add("Red");
        collection1.add("Green");
        collection1.add("Blue");
        a1.addAll(collection1);
        System.out.println("ArrayList elements of Second list: "+a1);
        System.out.println("Contains all element: "+collection.containsAll(collection));



    }
    }
  
