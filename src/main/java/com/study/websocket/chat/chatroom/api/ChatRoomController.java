package com.study.websocket.chat.chatroom.api;

import com.study.websocket.chat.chatroom.domain.entity.ChatRoom;
import com.study.websocket.chat.chatroom.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    private final AtomicInteger seq = new AtomicInteger(0);
    private final ChatRoomRepository repository;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", repository.findAll());
        return "/chat/rooms";
    }

    @PostMapping("/rooms")
    @ResponseBody
    public ChatRoom createChatRoom(@RequestParam String roomId) {
        return repository.createChatRoom(roomId);
    }

    /*@PostMapping("/rooms")
    public String createChatRoom(@RequestParam String roomId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("roomId", roomId);
        repository.createChatRoom(roomId);
        return "redirect:/chat/rooms/{roomId}";
    }*/

    @GetMapping("/rooms/{roomId}")
    public String room(@PathVariable String roomId, Model model) {
        ChatRoom room = repository.getChatRoom(roomId);
        model.addAttribute("room", room);
        model.addAttribute("member", "member" + seq.incrementAndGet());

        return "/chat/room-detail";
    }


    /*
    private final ChatRoomRepository repository;
    private final String listViewName;
    private final String detailViewName;
    private final AtomicInteger seq = new AtomicInteger(0);

    @Autowired
    public ChatRoomController(ChatRoomRepository repository, @Value("${viewname.chatroom.list}") String listViewName, @Value("${viewname.chatroom.detail}") String detailViewName) {
        this.repository = repository;
        this.listViewName = listViewName;
        this.detailViewName = detailViewName;
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", repository.getChatRooms());
        return listViewName;
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model) {
        ChatRoom room = repository.getChatRoom(id);
        model.addAttribute("room", room);
        model.addAttribute("member", "member" + seq.incrementAndGet());

        return detailViewName;
    }
     */
}
