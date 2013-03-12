package com.tdlee1230.genericgame3;

import android.os.Parcel;
import android.os.Parcelable;

public class Unit implements Parcelable
{
	// The class variables that will be parceled and passed around
	private int health;
	private int attack;
	private int defense;
	private String name;

	public int describeContents()
	{
		return 0;
	}

	public void writeToParcel(Parcel out, int flags)
	{
		out.writeInt(health);
		out.writeInt(attack);
		out.writeInt(defense);
		out.writeString(name);
	}

//	public class UnitCreator implements Parcelable.Creator<Unit>
	public static final Parcelable.Creator<Unit> CREATOR = new
			Parcelable.Creator<Unit>()
	{
		public Unit createFromParcel(Parcel in)
		{
			return new Unit(in);
		}

		public Unit[] newArray(int size)
		{
			return new Unit[size];
		}
	};

	// Constructor that reads in parcel
	// Apparently, there are no normal constructors unless we don't plan on
	// passing them between activities
	public Unit()
	{
		health = 1;
		attack = 1;
		defense = 1;
		name = "NONAME";
	}
	
	public Unit(Parcel in)
	{
		health = in.readInt();
		attack = in.readInt();
		defense = in.readInt();
		name = in.readString();
	}

	public void setHealth(int h)
	{
		health = h;
	}

	public int getHealth()
	{
		return health;
	}
}