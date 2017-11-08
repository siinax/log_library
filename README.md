# log_library
gradle
====
Setup 1.Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
	    
```
Step 2. Add the dependency
```
dependencies {
    compile 'com.github.siinax:log_library:v0.3'
}
```
maven
===
Setup 1.Add it in your root build.gradle at the end of repositories:
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Step 2. Add the dependency
```
<dependency>
    <groupId>com.github.siinax</groupId>
    <artifactId>log_library</artifactId>
    <version>v0.1</version>
</dependency>
```

