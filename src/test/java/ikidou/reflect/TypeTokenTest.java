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
import java.util.ArrayList;

public class TypeTokenTest {
    @Test
    public void testClass() {
        Type type = new TypeToken<String>() {
        }.getType();
        Assert.assertEquals(type, String.class);
    }

    @Test
    public void testParameterizedType() {
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        Type type1 = new ArrayList<String>() {
        }.getClass().getGenericSuperclass();

        Assert.assertEquals(type, type1);
    }
}