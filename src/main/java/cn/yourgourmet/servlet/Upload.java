package cn.yourgourmet.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import cn.yourgourmet.service.UserOperation;

@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (Objects.equals(type, "updateAvatar")) {
            Part filePart = request.getPart("avatar");
            String userId = request.getParameter("userId");
            //存入盘中
            String fileExt = filePart.getSubmittedFileName().substring(filePart.getSubmittedFileName().lastIndexOf(".") + 1);
            // 获取userId作为文件名
            String fileName = userId + "." + fileExt;
            // 获取文件保存的路径
            String savePath = getServletContext().getRealPath("/img/profile/avatar");
            // 将文件保存到指定的目录中
            //最终路径
            String filePath = savePath + File.separator + fileName;
            // 存入数据库
            if (UserOperation.updateUserAvatar(userId, "avatar/" + fileName )){
                filePart.write(filePath);
                response.getWriter().print("true");
            } else{
                response.getWriter().print("false");
            }
        }
    }
}
