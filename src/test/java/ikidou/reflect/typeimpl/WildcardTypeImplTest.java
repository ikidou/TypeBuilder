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

package ikidou.reflect.typeimpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import ikidou.reflect.TypeBuilder;

public class WildcardTypeImplTest {
    WildcardTypeImpl wildcardType1;
    WildcardTypeImpl wildcardType2;


    @Test(expected = IllegalArgumentException.class)
    public void testArgsCount() throws Exception {
        new WildcardTypeImpl(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgsType1() throws Exception {
        new WildcardTypeImpl(new Class[]{CharSequence.class, String.class}, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgsType2() throws Exception {
        new WildcardTypeImpl(new Class[]{StringBuffer.class, String.class}, null);
    }

    @Before
    public void init() {
        wildcardType1 = new WildcardTypeImpl(new Class[]{String.class}, null);
        wildcardType2 = new WildcardTypeImpl(null, new Class[]{Character.class});
    }

    @Test
    public void testGetUpperBounds() throws Exception {
        Assert.assertArrayEquals(new Type[0], wildcardType1.getUpperBounds());
        Assert.assertArrayEquals(new Type[]{Character.class}, wildcardType2.getUpperBounds());
    }

    @Test
    public void testGetLowerBounds() throws Exception {
        Assert.assertArrayEquals(new Type[]{String.class}, wildcardType1.getLowerBounds());
        Assert.assertArrayEquals(new Type[]{}, wildcardType2.getLowerBounds());
    }
}