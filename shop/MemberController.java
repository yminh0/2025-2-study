package com.example.shop.member;


import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    // 멤버 등록
    @PostMapping()
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request){
        Long memberId = memberService.createMember(request);
        return ResponseEntity.created(URI.create("/members/" + memberId)).build();
    }

    // 모든 멤버 조회
    @GetMapping()
    public ResponseEntity<List<Member>> getAllMembers(){
        // Service 계층에서 회원 목록을 가져온다.
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // 특정 멤버 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId){
        Member member = memberService.getMemberById(memberId);
        return ResponseEntity.ok(member);
    }

    // 멤버 정보 수정
    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request) {
        memberService.updateMember(memberId, request);
        return ResponseEntity.ok().build();
    }

    // 멤버 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build(); // 204 no content
    }
}
