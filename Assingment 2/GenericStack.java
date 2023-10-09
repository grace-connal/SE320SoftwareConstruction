public class GenericStack<E> 
{
    private E[] list;
    private final int DEFAULT_CAPACITY = 4;

    public GenericStack()
    {
        list = (E[])new Object[DEFAULT_CAPACITY];
    }

    public GenericStack(int capacity)
    {
        list = (E[])new Object[capacity];
    }

    public int getSize()
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == null)
            {
                return i + 1;
            }
        }
    return list.length;
    }

    public E peek()
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            if (list[i+1] == null)
            {
                return list[i];
            }
        }
        return list[list.length - 1];
    }

    public void push(E o)
    { 
        if (list[list.length - 1] != null)
        {
           increaseCapacity();
        }
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == null)
            {
                list[i] = o;
                return;
            }
        }
    }

    public E pop()
    { 
        for (int i = list.length - 1; i >=0; i--)
        {
            if (list[i] != null)
            {
                E outputValue = list[i];
                list[i] = null; 
                return outputValue;
            }
        }

        return null;
    }

    private void increaseCapacity()
    {
        E[] lowerCapacityList = (E[])new Object[list.length];
        for (int i = 0; i < list.length; i++)
        {
            lowerCapacityList[i] = list[i];
        }
        list = (E[])new Object[lowerCapacityList.length * 2];
        for (int i = 0; i < lowerCapacityList.length; i++)
        {
            list[i] = lowerCapacityList[i];
        }
    }

    public boolean isEmpty()
    {
        for (int i = list.length - 1; i >=0; i--)
        {
            if (list[i] != null)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString()
    {
        String output = "stack: ";
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == null)
            {
                return output;
            }
            output += list[i].toString() + " ";
        }
        return output;
    }
}
