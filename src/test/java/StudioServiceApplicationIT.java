import com.mschmidt.sss.StudioServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudioServiceApplication.class)
@AutoConfigureMockMvc
public class StudioServiceApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllStudios() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/studio")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleStudio() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/studio/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleStudio() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/studio/23")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewStudio() throws Exception {
        String newStudio = "{\"name\":\"VGO Office\",\"description\":\"Vigo - a test office\",\"country\":\"Spain\",\"headCount\":23}";
        mockMvc.perform(MockMvcRequestBuilders.post("/studio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newStudio)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

}
