/*
 * Copyright 2013 Proofpoint Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.kairosdb.core.datastore;

public class Sampling extends Duration
{
	public Sampling()
	{
		super();
	}

	public Sampling(int value, TimeUnit unit)
	{
		super(value, unit);
	}

	/**
	 Works for any time unit except month.  Months are special cased in
	 the RangeAggregator

	 Note this does not account for leap years
	 @return
	 */
	public long getSampling()
	{
		long val = value;
		switch (unit)
		{
			case YEARS: val *= 52;
			case WEEKS: val *= 7;
			case DAYS: val *= 24;
			case HOURS: val *= 60;
			case MINUTES: val *= 60;
			case SECONDS: val *= 1000;
			case MILLISECONDS:
		}

		return (val);
	}
}
