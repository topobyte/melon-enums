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

import java.util.Iterator;

public class Joiner
{

	public static Joiner on(String string)
	{
		return new Joiner(string);
	}

	private String separator;

	public Joiner(String separator)
	{
		this.separator = separator;
	}

	public String join(Iterable<String> values)
	{
		StringBuilder buffer = new StringBuilder();
		Iterator<String> iterator = values.iterator();
		while (iterator.hasNext()) {
			buffer.append(iterator.next());
			if (iterator.hasNext()) {
				buffer.append(separator);
			}
		}
		return buffer.toString();
	}

}
