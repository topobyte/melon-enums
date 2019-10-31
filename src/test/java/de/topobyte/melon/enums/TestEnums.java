// Copyright 2019 Sebastian Kuerten
//
// This file is part of melon-enums.
//
// melon-enums is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// melon-enums is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with melon-enums. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.melon.enums;

import org.junit.Assert;
import org.junit.Test;

import de.topobyte.melon.enums.naming.SimpleEnumNamer;

public class TestEnums
{

	private static enum Foo {

		TEST,
		TEST_A,
		TEST_B;

	}

	@Test
	public void testDefault()
	{
		EnumLookup<Foo> lookup = EnumLookups.build(Foo.class);
		Assert.assertEquals(Foo.TEST, lookup.get("TEST"));
		Assert.assertEquals(Foo.TEST_A, lookup.get("TEST_A"));
		Assert.assertEquals(Foo.TEST_B, lookup.get("TEST_B"));
		Assert.assertNull(lookup.get("NOT_EXISTING"));
	}

	@Test
	public void testSimple()
	{
		EnumLookup<Foo> lookup = EnumLookups.build(Foo.class,
				new SimpleEnumNamer<>());
		Assert.assertEquals(Foo.TEST, lookup.get("test"));
		Assert.assertEquals(Foo.TEST_A, lookup.get("test-a"));
		Assert.assertEquals(Foo.TEST_B, lookup.get("test-b"));
		Assert.assertNull(lookup.get("not-existing"));
	}

	@Test
	public void testDefaultWithDefaultValue()
	{
		EnumLookup<Foo> lookup = EnumLookups.build(Foo.class, Foo.TEST_A);
		Assert.assertEquals(Foo.TEST, lookup.get("TEST"));
		Assert.assertEquals(Foo.TEST_A, lookup.get("TEST_A"));
		Assert.assertEquals(Foo.TEST_B, lookup.get("TEST_B"));
		Assert.assertEquals(Foo.TEST_A, lookup.get("NOT_EXISTING"));
	}

	@Test
	public void testSimpleWithDefaultValue()
	{
		EnumLookup<Foo> lookup = EnumLookups.build(Foo.class,
				new SimpleEnumNamer<>(), Foo.TEST_A);
		Assert.assertEquals(Foo.TEST, lookup.get("test"));
		Assert.assertEquals(Foo.TEST_A, lookup.get("test-a"));
		Assert.assertEquals(Foo.TEST_B, lookup.get("test-b"));
		Assert.assertEquals(Foo.TEST_A, lookup.get("not-existing"));
	}

}
