# TypeBuilder

一个用于生成泛型的简易Builder

#### Example for List&lt;String&gt;
```java
Type type = TypeBuilder
        .newInstance(List.class)
        .addTypeParam(String.class)
        .build();
```

#### Example for List&lt;? super String&gt;
```java
Type type = TypeBuilder
        .newInstance(List.class)
        .addTypeParamSuper(String.class)
        .build();
```

#### Example for List&lt;? extends CharSequence&gt;
```java
Type type = TypeBuilder
        .newInstance(List.class)
        .addTypeParamExtends(CharSequence.class)
        .build();
```

#### Example for Map&lt;String, String[]&gt;
```java
Type type = TypeBuilder
        .newInstance(HashMap.class)
        .addTypeParam(String.class)
        .addTypeParam(String[].class)
        .build();
```

#### Example for Map&lt;String, List&lt;String&gt;&gt;
```java
Type type = TypeBuilder
        .newInstance(Map.class)
        .addTypeParam(String.class)
        .beginSubType(List.class) //开始 List<String> 部分
        .addTypeParam(String.class) //设置List的泛型值
        .endSubType() //结束 List<String> 部分
        .build();
```
#### Download
Get it from [JitPack repository](https://jitpack.io/#ikidou/TypeBuilder/1.0) use Gradle or Maven.  
Download [JAR](https://jitpack.io/com/github/ikidou/TypeBuilder/1.0/TypeBuilder-1.0.jar) and
[Source](https://jitpack.io/com/github/ikidou/TypeBuilder/1.0/TypeBuilder-1.0-sources.jar)  


#### 有什么用
当你无法通过子类去获取泛型时，不用写一长串的嵌套或去实现部分Type接口。

License
-------
    Copyright 2016 ikidou

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
