/*
 * Copyright 2016 ikidou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ikidou.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import ikidou.reflect.typeimpl.ParameterizedTypeImpl;

public class TypeBuilderTest {
    @Test
    public void test() {
        Type type = TypeBuilder
                .newInstance(HashMap.class)
                .addTypeParam(String.class)
                .beginSubType(List.class)
                .addTypeParam(CharSequence.class)
                .endSubType()
                .build();
        System.out.println(type.toString());

        Type type1 = new ParameterizedTypeImpl(HashMap.class, new Type[]{String.class, new ParameterizedTypeImpl(List.class, new Type[]{CharSequence.class}, null)}, null);
        Assert.assertEquals(type, type1);
        System.out.println(String[][][].class.getComponentType().getComponentType().getName());
    }
}