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

import de.topobyte.melon.enums.naming.DefaultEnumNamer;
import de.topobyte.melon.enums.naming.EnumNamer;

public class EnumLookups
{

	public static <T extends Enum<T>> EnumLookup<T> build(Class<T> clazz)
	{
		DefaultEnumNamer<T> namer = new DefaultEnumNamer<T>();
		return build(clazz, namer);
	}

	public static <T extends Enum<T>> EnumLookup<T> build(Class<T> clazz,
			T defaultValue)
	{
		DefaultEnumNamer<T> namer = new DefaultEnumNamer<T>();
		return build(clazz, namer, defaultValue);
	}

	public static <T extends Enum<T>> EnumLookup<T> build(Class<T> clazz,
			EnumNamer<T> namer)
	{
		EnumLookup<T> lookup = new EnumLookup<T>();

		T[] values = clazz.getEnumConstants();
		for (T value : values) {
			lookup.put(namer.getName(value), value);
		}

		return lookup;
	}

	public static <T extends Enum<T>> EnumLookup<T> build(Class<T> clazz,
			EnumNamer<T> namer, T defaultValue)
	{
		EnumLookup<T> lookup = build(clazz, namer);
		lookup.setDefaultValue(defaultValue);
		return lookup;
	}

}
