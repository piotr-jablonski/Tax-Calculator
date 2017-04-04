package pl.sda.spring2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.hamcrest.Matchers;

@RunWith(JUnitParamsRunner.class)
public class FileControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private FileProcessor fileProcessor;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(new FileController(new FileProcessor())).build();
	}

	@Test
	@Parameters({
		"Pieski dwa", 
		"kotki dwa"})
	public void test(String text) throws Exception {
		Mockito.when(fileProcessor.delete()).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.delete("/file"))//
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.when(fileProcessor.save(text)).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.post("/file").content(text))//
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.when(fileProcessor.get()).thenReturn(Arrays.asList(text));
		mockMvc.perform(MockMvcRequestBuilders.get("/file"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0]", Matchers.equalTo(text)));
	}
}
