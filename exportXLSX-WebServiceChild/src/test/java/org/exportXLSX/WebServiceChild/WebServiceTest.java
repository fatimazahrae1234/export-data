package org.exportXLSX.WebServiceChild;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyVararg;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;

import org.exportXLSX.ServiceChild1.Departement;
import org.exportXLSX.ServiceChild1.FileData;
import org.exportXLSX.ServiceChild1.Personne;
import org.exportXLSX.ServiceChild1.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.ArgumentMatchers.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

class WebServiceTest {
	
	
	@InjectMocks
	controlleur controlleur;
	
	@Mock
	Service service;
	
	FileData fileData;
		
	@BeforeEach
	void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
		 fileData = new FileData("datamultiple.xlsx","data");
	}

	@Test
	final void testMultiExport() throws Exception {

		when(service.multiExport(anyVararg())).thenReturn(fileData);
		FileData res = controlleur.multiExport();
		assertNotNull(res);
		assertEquals("datamultiple.xlsx", res.getNomFichier());
		assertEquals(fileData.getData(), res.getData());
	}
	

}
