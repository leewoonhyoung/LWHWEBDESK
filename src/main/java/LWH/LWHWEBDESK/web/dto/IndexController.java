package LWH.LWHWEBDESK.web.dto;

import LWH.LWHWEBDESK.config.auth.LoginUser;
import LWH.LWHWEBDESK.config.auth.dto.SessionUser;
import LWH.LWHWEBDESK.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController {


    private final PostsService postsService;
    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index(Model model){
//        model.addAttribute("posts", postsService.findAllDesc());
//
//        SessionUser user = (SessionUser)  httpSession.getAttribute("user");
//
//        if(user != null){
//            model.addAttribute("username", user.getName());
//        }
//        return "index";
//
//    }
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        if(user!= null){
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }


    @GetMapping("/posts/save")
    public String  postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto find_id = postsService.findById(id);
        model.addAttribute("post", find_id);
        return "posts-update";
    }






}
