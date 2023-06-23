# Map of Hashmatique

This Java project, **Map of Hashmatique**, demonstrates the use of HashMap to create and manage a track list of songs.

### HashMaps in Java

A **HashMap** is a data structure in Java that stores key-value pairs. It provides efficient storage and retrieval of elements based on their keys. In this project, a HashMap is used to store track titles as keys and corresponding song lyrics as values.

## Creating a Track List with HashMap

To create a track list using HashMap, the following steps are followed:

### 1. Creating the HashMap:

- A **`HashMap`** is created using the line
    ```java
    HashMap<String, String> map = new HashMap<String, String>();.
    ```
- The `HashMap` is defined to store keys of type String (track title) and values of type String (song lyrics).

### 2. Adding Songs to the Track List:

- Songs are added to the track list using the `put()` method of the `HashMap`.
- Each song is added with the track title as the key and the song lyrics as the value.

### 3. Retrieving a Song:

- A specific song can be retrieved from the track list using the `get()` method of the `HashMap`.
- The track title is provided as the argument, and the corresponding song lyrics are returned.

### 4. Printing the Track List:

- The track list is printed in the format "Track: `{Track Title}` - Lyrics: `{Song Lyrics}`..." using a loop.
- The loop iterates over the keys of the HashMap using the `keySet()` method.
- For each **key** (track title), the corresponding **value** (song lyrics) is retrieved using the `get()` method, and both are printed.