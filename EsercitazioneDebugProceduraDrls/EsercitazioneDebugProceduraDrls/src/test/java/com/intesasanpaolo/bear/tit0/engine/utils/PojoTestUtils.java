package com.intesasanpaolo.bear.tit0.engine.utils;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class PojoTestUtils {

	private static final Validator ACCESSOR_FULL_VALIDATOR = ValidatorBuilder.create()
//            .with(new SetterMustExistRule())
//            .with(new GetterMustExistRule())
            .with(new SetterTester())
            .with(new GetterTester())
            .build();

	public static void validate(final Class<?> clazz) {
//		final ArrayList<PojoField> pojoFields = new ArrayList<>(PojoFieldFactory.getPojoFields(clazz));
//		final List<PojoMethod> pojoMethods = PojoMethodFactory.getPojoMethods(clazz);
//		final PojoClassImpl pojoClass = new PojoClassImpl(clazz, pojoFields, pojoMethods);		
//		ACCESSOR_FULL_VALIDATOR.validate(pojoClass);
		ACCESSOR_FULL_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
		
	}
	
//	public static void validateGetter(final Class<?> clazz) {
//		final ArrayList<PojoField> pojoFields = new ArrayList<>(PojoFieldFactory.getPojoFields(clazz));
//		final List<PojoMethod> pojoMethods = PojoMethodFactory.getPojoMethods(clazz);
//		final PojoClassImpl pojoClass = new PojoClassImpl(clazz, pojoFields, pojoMethods);
//		
//		ACCESSOR_GET_VALIDATOR.validate(pojoClass);
//		
//	}
}
