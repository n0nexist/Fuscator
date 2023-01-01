# Fuscator
Use this simple tool to hide real string constants from decompilation.

# Example
<i>$</i> java Fuscator<br>
<i>></i> hello

<b>Example output:</b>
```
(new Object() {
    int t;
    public String toString() {
        byte[] buf = new byte[5];
        t = 1220204165; buf[0] = (byte) (t >>> 4);
        t = 1731395377; buf[1] = (byte) (t >>> 15);
        t = -1241489993; buf[2] = (byte) (t >>> 23);
        t = 56640078; buf[3] = (byte) (t >>> 19);
        t = 350056403; buf[4] = (byte) (t >>> 8);
        return new String(buf);
    }
}.toString())
```

# Implement to your code
<b>Before:</b>
````
doSomethingWithSecret("hello");
````
<br>
<b>After:</b><br>
````
doSomethingWithSecret((new Object() {
    int t;
    public String toString() {
        byte[] buf = new byte[5];
        t = 1220204165; buf[0] = (byte) (t >>> 4);
        t = 1731395377; buf[1] = (byte) (t >>> 15);
        t = -1241489993; buf[2] = (byte) (t >>> 23);
        t = 56640078; buf[3] = (byte) (t >>> 19);
        t = 350056403; buf[4] = (byte) (t >>> 8);
        return new String(buf);
    }
}.toString()));
````
