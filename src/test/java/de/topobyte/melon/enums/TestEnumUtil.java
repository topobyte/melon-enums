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

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import de.topobyte.melon.enums.naming.DefaultEnumNamer;
import de.topobyte.melon.enums.naming.SimpleEnumNamer;

public class TestEnumUtil
{

	private static enum Foo {

		TEST,
		TEST_A,
		TEST_B;

	}

	@Test
	public void testArrayDefaultSeparator()
	{
		Assert.assertEquals("TEST, TEST_A, TEST_B",
				EnumUtil.buildNameList(Foo.values()));
		Assert.assertEquals("TEST, TEST_A, TEST_B",
				EnumUtil.buildNameList(Foo.values(), new DefaultEnumNamer<>()));
		Assert.assertEquals("test, test-a, test-b",
				EnumUtil.buildNameList(Foo.values(), new SimpleEnumNamer<>()));
	}

	@Test
	public void testArraySemicolon()
	{
		Assert.assertEquals("TEST;TEST_A;TEST_B",
				EnumUtil.buildNameList(Foo.values(), ";"));
		Assert.assertEquals("TEST;TEST_A;TEST_B", EnumUtil
				.buildNameList(Foo.values(), new DefaultEnumNamer<>(), ";"));
		Assert.assertEquals("test;test-a;test-b", EnumUtil
				.buildNameList(Foo.values(), new SimpleEnumNamer<>(), ";"));
	}

	@Test
	public void testClassDefaultSeparator()
	{
		Assert.assertEquals("TEST, TEST_A, TEST_B",
				EnumUtil.buildNameList(Foo.class));
		Assert.assertEquals("TEST, TEST_A, TEST_B",
				EnumUtil.buildNameList(Foo.class, new DefaultEnumNamer<>()));
		Assert.assertEquals("test, test-a, test-b",
				EnumUtil.buildNameList(Foo.class, new SimpleEnumNamer<>()));
	}

	@Test
	public void testClassSemicolon()
	{
		Assert.assertEquals("TEST;TEST_A;TEST_B",
				EnumUtil.buildNameList(Foo.class, ";"));
		Assert.assertEquals("TEST;TEST_A;TEST_B", EnumUtil
				.buildNameList(Foo.class, new DefaultEnumNamer<>(), ";"));
		Assert.assertEquals("test;test-a;test-b", EnumUtil
				.buildNameList(Foo.class, new SimpleEnumNamer<>(), ";"));
	}

	@Test
	public void testListDefaultSeparator()
	{
		Assert.assertEquals("TEST, TEST_A, TEST_B",
				EnumUtil.buildNameList(Arrays.asList(Foo.values())));
		Assert.assertEquals("TEST, TEST_A, TEST_B", EnumUtil.buildNameList(
				Arrays.asList(Foo.values()), new DefaultEnumNamer<>()));
		Assert.assertEquals("test, test-a, test-b", EnumUtil.buildNameList(
				Arrays.asList(Foo.values()), new SimpleEnumNamer<>()));
	}

	@Test
	public void testListSemicolon()
	{
		Assert.assertEquals("TEST;TEST_A;TEST_B",
				EnumUtil.buildNameList(Arrays.asList(Foo.values()), ";"));
		Assert.assertEquals("TEST;TEST_A;TEST_B", EnumUtil.buildNameList(
				Arrays.asList(Foo.values()), new DefaultEnumNamer<>(), ";"));
		Assert.assertEquals("test;test-a;test-b", EnumUtil.buildNameList(
				Arrays.asList(Foo.values()), new SimpleEnumNamer<>(), ";"));
	}

}
