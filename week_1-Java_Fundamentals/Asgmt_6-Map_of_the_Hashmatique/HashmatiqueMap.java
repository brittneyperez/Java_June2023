import java.util.HashMap;

public class HashmatiqueMap {
    
    public static void main(String[] args) {
        
        HashMap<String, String> map = new HashMap<String, String>(); //? Creating a trackList of type HashMap.
        
        //? Using map.put(key : value), add in at least 4 songs that are stored by title.
        map.put("我不曾忘记", "我的破木香");
        map.put("離れ離れの聞き君へ", "あの空は戻らない");
        map.put("让风告诉你", "当你的天空突然 下起了大雨 那时我在为你炸乌云");
        map.put("Rubia", "Life blooms like a flower");
        
        // Pull out one of the songs by its track title.
        System.out.println(map.get("我不曾忘记")); // 我的破木香
        
        //? Print out all the track names and lyrics in the format 'Track:  - Lyrics: '.
        for ( String key : map.keySet() ) {
            //                                key : args
            System.out.println( String.format("Track: %s - Lyrics: %s...", key, map.get(key)));
        }
        /* Output:
        Track: 我不曾忘记 - Lyrics: 我的破木香...
        Track: 让风告诉你 - Lyrics: 当你的天空突然 下起了大雨 那时我在为你炸乌云...
        Track: 離れ離れの聞き君へ - Lyrics: あの空は戻らない...
        Track: Rubia - Lyrics: Life blooms like a flower...
        */
    }
}
