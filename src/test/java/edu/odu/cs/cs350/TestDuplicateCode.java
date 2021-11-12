package src.test.java.edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.Source;

import org.junit.jupiter.api.Test;
 

public class TestDuplicateCode {
	
DuplicateCode test1 = new DuplicateCode(0,0,"filename");	
	
@Test 
void testInitialSetup() {

 
 assertEquals(DuplicateCode.getLine(), 0);
 assertEquals(DuplicateCode.getColumn(), 0);
 assertEquals(DuplicateCode.getFilename(), "filename");
}

void testGetSet() {
	//SettingLine//
	DuplicateCode.setLine(6);
	DuplicateCode.setColumn(3);
	
	assertThat(DuplicateCode.getLine(), is(6));
	assertThat(DuplicateCode.getColumn(),is(3);
	
	
}

}

//Test Accessors and Mutators/

