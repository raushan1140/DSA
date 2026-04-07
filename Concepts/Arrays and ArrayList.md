# Arrays:
    
    Collection of same type of elements, stored in contigious memory.
    int arr[] = {10,20,30,40}

    -> Access using index (0-based)

# Why Arrays? 
    
    -> Stores multiple values of same data types.
    -> Fast access using index.
    -> Simple and memory efficent.

# Memory and Indexing:
    
    if 
        base_address = 100
        int = 4 bytes
    then, 
        arr[0] -> 100
        arr[1] -> 104
        arr[2] -> 108

    Formula: Address of arr[i] = base + (i*size)

    Arrays gives O(1) access because address is calculated directly.

# Time Complexity:
    
    -> Access = O(1)
    -> Search (unsorted) = O(n)
    -> Search (sorted + binary) = O(logN)
    -> Insertion (middle) = O(n)
    -> Deletion (middle) = O(n)


# Why contigious memory matters?
   
    -> Fast Access
    -> Index-based retrival.

    Arrays support constant time random access due to contigious memory allocation.

# How Array is Stored in Memory?

    int arr[] = new int[5];
    
    -> int takes 4 bytes
    -> contigoius allocation
    -> arr[i] is O(1)
    -> Random access is Fast.

# Why insertion is O(n)?

    -> Because elements need shifting.

# Why Array is Fixed size?

    When array is created: 
        -> Memory is located once.
        -> size cannot grow or shrink.

# Why can't array grow dynamically?

    -> Contigious memory.
    -> Reallocation is costly.

    Thats why arraylist, vector exists.

# Seatching in Array:

    1. Linear Search:
        -> Work on any array.
        -> Tc = O(n)
    2. Binary Search:
        -> Works only on sorted array.
        -> Tc = O(logN)


# Array vs ArrayList

    Array: 
        
        Fixed size data structure that stores elements of same data types in contigious memory allocations.

        Key Characterstics:

            -> Size is fixed at creation.
            -> Stores premitive + Objects.
            -> Fast access using index.
            -> Memory allocated at once.

        Advantages:

            -> Fast access.
            -> Less memory Overhead.
            -> Simple and efficient for fixed size data.
        
        Limitations:

            -> Size cannot change
            -> Insertion / Deletion is costly.
            -> No Built-in methods.

    



