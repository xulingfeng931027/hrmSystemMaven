package controllerTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import paul.domain.Department;
import paul.web.controller.DepartmentController;
import paul.web.service.HrmService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by Administrator on 2017/7/16 0016.
 */

public class DepartmentControllerTest {
    private HrmService hrmService;
    private DepartmentController controller;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        hrmService = mock(HrmService.class);
        controller = new DepartmentController(hrmService);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void addDept() throws Exception {
//        mockMvc.perform(get("/dept/addDept?flag=1")).
//                andExpect(view().name("dept/showAddDept"));

        Department department = new Department();
        department.setName("项目部");
        when(hrmService.addDepartment(department)).thenReturn(1);
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
//                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.
//                        post("/dept/addDept?flag=2");
//        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
//        resultActions.andExpect((redirectedUrl("/dept/selectDept")));
        mockMvc.perform(post("/dept/addDept?flag=2"))
                .andExpect((redirectedUrl("/dept/selectDept")));
    }

    @Test
    public void showDept() throws Exception {
    }

    @Test
    public void removeDept() throws Exception {
    }

    @Test
    public void updateDept() throws Exception {
    }

}