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

import java.util.ArrayList;
import java.util.List;

import de.topobyte.melon.enums.naming.DefaultEnumNamer;
import de.topobyte.melon.enums.naming.EnumNamer;

public class EnumUtil<T extends Enum<T>>
{

	public static <T extends Enum<T>> String buildNameList(Class<T> clazz)
	{
		return buildNameList(clazz.getEnumConstants());
	}

	public static <T extends Enum<T>> String buildNameList(Class<T> clazz,
			EnumNamer<T> namer)
	{
		return buildNameList(clazz.getEnumConstants(), namer);
	}

	public static <T extends Enum<T>> String buildNameList(Class<T> clazz,
			String separator)
	{
		return buildNameList(clazz.getEnumConstants(),
				new DefaultEnumNamer<T>(), separator);
	}

	public static <T extends Enum<T>> String buildNameList(Class<T> clazz,
			EnumNamer<T> namer, String separator)
	{
		return buildNameList(clazz.getEnumConstants(), namer, separator);
	}

	public static <T extends Enum<T>> String buildNameList(T[] values)
	{
		return buildNameList(values, new DefaultEnumNamer<>(), ", ");
	}

	public static <T extends Enum<T>> String buildNameList(T[] values,
			EnumNamer<T> namer)
	{
		return buildNameList(values, namer, ", ");
	}

	public static <T extends Enum<T>> String buildNameList(T[] values,
			String separator)
	{
		return buildNameList(values, new DefaultEnumNamer<T>(), separator);
	}

	public static <T extends Enum<T>> String buildNameList(T[] values,
			EnumNamer<T> namer, String separator)
	{
		List<String> names = new ArrayList<>();
		for (T value : values) {
			names.add(namer.getName(value));
		}
		return Joiner.on(separator).join(names);
	}

	public static <T extends Enum<T>> String buildNameList(Iterable<T> values)
	{
		return buildNameList(values, new DefaultEnumNamer<>(), ", ");
	}

	public static <T extends Enum<T>> String buildNameList(Iterable<T> values,
			EnumNamer<T> namer)
	{
		return buildNameList(values, namer, ", ");
	}

	public static <T extends Enum<T>> String buildNameList(Iterable<T> values,
			String separator)
	{
		return buildNameList(values, new DefaultEnumNamer<T>(), separator);
	}

	public static <T extends Enum<T>> String buildNameList(Iterable<T> values,
			EnumNamer<T> namer, String separator)
	{
		List<String> names = new ArrayList<>();
		for (T value : values) {
			names.add(namer.getName(value));
		}
		return Joiner.on(separator).join(names);
	}

}
