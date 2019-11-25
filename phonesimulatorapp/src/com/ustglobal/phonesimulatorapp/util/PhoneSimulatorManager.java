package com.ustglobal.phonesimulatorapp.util;

import com.ustglobal.phonesimulatorapp.dao.PhoneSimulatorDao;
import com.ustglobal.phonesimulatorapp.dao.PhoneSimulatorImplDao;

public class PhoneSimulatorManager {
public static PhoneSimulatorDao getInstanceOfPhoneSimulatorDao() {
	return new PhoneSimulatorImplDao();
}
}
