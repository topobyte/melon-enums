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

import java.util.HashMap;
import java.util.Map;

import de.topobyte.melon.enums.naming.EnumNamer;

public class EnumLookup<T extends Enum<T>> implements EnumNamer<T>
{

	private T defaultValue = null;
	private Map<String, T> map = new HashMap<>();
	private Map<T, String> reverseMap = new HashMap<>();

	public void put(String name, T element)
	{
		map.put(name, element);
		reverseMap.put(element, name);
	}

	public void setDefaultValue(T defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	public T get(String name)
	{
		T value = map.get(name);
		if (value != null) {
			return value;
		}
		return defaultValue;
	}

	@Override
	public String getName(T value)
	{
		return reverseMap.get(value);
	}

}