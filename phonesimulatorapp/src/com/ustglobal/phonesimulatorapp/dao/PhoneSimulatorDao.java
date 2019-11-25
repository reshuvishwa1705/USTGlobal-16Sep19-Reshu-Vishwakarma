package com.ustglobal.phonesimulatorapp.dao;

import java.util.List;

import com.ustglobal.phonesimulatorapp.dto.PhoneSimulatorDto;

public interface PhoneSimulatorDao {
public List<PhoneSimulatorDto> showAllContact();
public PhoneSimulatorDto searchContact(String name);
public int addContact(PhoneSimulatorDto dto);
public int deleteContact(String name);
public int editContact(PhoneSimulatorDto dto);
}
