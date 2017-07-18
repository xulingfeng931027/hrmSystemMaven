package paul.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import paul.domain.Document;
import paul.domain.User;
import paul.utils.PageModel;
import paul.web.service.HrmService;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("document")
public class DocumentController {
    @Autowired
    private HrmService hrmService;

    //添加文档
    @RequestMapping("/showAddDocument")
    public String showAddDocument() throws IOException {

        return "document/showAddDocument";
    }

    @RequestMapping("/addDocument")
    public String addDocument(Document document, HttpSession session, @RequestPart Part file) throws IOException {
        String fileName = file.getSubmittedFileName();
        String savaFileName = System.currentTimeMillis() + fileName;
        File filePath = new File("c:/upload/");

        if (!filePath.exists()) ;
        filePath.mkdirs();

        file.write(filePath + "\\" + savaFileName);
        User user = (User) session.getAttribute("user");
        document.setFilename(savaFileName);
        document.setUser(user);
        hrmService.addDocument(document);
        return "redirect:/document/selectDocument";
    }

    //查询文档
    @RequestMapping("selectDocument")
    public String showDocument(Model model, Integer pageIndex, @ModelAttribute Document document) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        List<Document> list = hrmService.findAllDocument(document, pageModel);
        model.addAttribute("documents", list);
        model.addAttribute(pageModel);
        return "document/document";
    }

    //处理删除请求
    @RequestMapping("/removeDocument")
    public String removeDocument(String ids) {
        //分解字符串
        String[] idArray = ids.split(",");
//        根据id删除即可
        for (String id : idArray) {
            hrmService.removeDocumentById(Integer.parseInt(id));
        }
        return "redirect:/document/selectDocument";
    }

    //处理修改请求
    @RequestMapping("/updateDocument")
    public String updateDocument(Document document, String flag, Model model) {
        if (flag.equals("1")) {
            Document target = hrmService.findDocumentById(document.getId());
            model.addAttribute(target);
            return "document/showUpdateDocument";
        }
        hrmService.modifyDocumentById(document);
        return "redirect:/document/selectDocument";
    }

    //处理下载请求
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(int id, HttpSession session) throws IOException {
        //根据id得到下载的文档
        Document target = hrmService.findDocumentById(id);
        String fileName = target.getFilename();
        //得到要下载的文件
        File file = new File("C:/upload/" + fileName);
        //创建SpringFrameWork的HttpHeader对象
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        //通知浏览器以下载方式打开
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //采用最常见的二进制流下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);

    }

}
