package ua.external.base.oop.droid.droids;

import java.util.Objects;

public class DoublePowerDroid extends AthleteDroid{

    protected DoublePowerDroid(Builder builder) {
        super(builder);
        super.setMultiplyPower(2);
    }

}
