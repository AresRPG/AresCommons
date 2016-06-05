package fr.aresrpg.commons.infra.serialization.field;

import fr.aresrpg.commons.domain.serialization.field.FieldModifier;
import fr.aresrpg.commons.domain.unsafe.UnsafeAccessor;

import java.lang.reflect.Field;

public class UnsafeFieldModifier implements FieldModifier {

	@Override
	public void setValue(Field field, Object instance, Object value) {
		UnsafeAccessor.getUnsafe().putObject(instance , UnsafeAccessor.getUnsafe().objectFieldOffset(field) , value);
	}

	@Override
	public Object getValue(Field field, Object instance) {
		return UnsafeAccessor.getUnsafe().getObject(instance , UnsafeAccessor.getUnsafe().objectFieldOffset(field));
	}

	@Override
	public boolean canProcess(Field f) {
		return true;
	}

	@Override
	public void preprocess(Field field) {
		//Don't need preprocess
	}

}
