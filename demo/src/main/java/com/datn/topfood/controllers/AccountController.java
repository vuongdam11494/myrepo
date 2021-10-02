package com.datn.topfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datn.topfood.dto.request.BlockFriendRequest;
import com.datn.topfood.dto.request.ReplyInvitationFriendRequest;
import com.datn.topfood.dto.request.SendFriendInvitationsRequest;
import com.datn.topfood.dto.response.FriendProfileResponse;
import com.datn.topfood.dto.response.Response;
import com.datn.topfood.services.interf.AccountService;
import com.datn.topfood.util.constant.Message;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService friendServic;

	@Operation(description = "API xem thông tin profile bạn bè")
	@GetMapping("/profile/{accountId}")
	ResponseEntity<Response<FriendProfileResponse>> friendProfile(@PathVariable Long accountId) {
		return ResponseEntity.ok(new Response<FriendProfileResponse>(true, Message.OTHER_SUCCESS,
				friendServic.getFiendProfileByAccountId(accountId)));
	}

	@Operation(description = "API gửi lời mời kết bạn")
	@PostMapping("/send-friend-invitations")
	ResponseEntity<Response<Boolean>> sendFriendInvitations(
			@RequestBody SendFriendInvitationsRequest friendInvitationsRequest) {
		return ResponseEntity.ok(new Response<Boolean>(true, Message.OTHER_SUCCESS,
				friendServic.sendFriendInvitations(friendInvitationsRequest)));
	}

	@Operation(description = "API chặn bạn bè")
	@PostMapping("/block-friend")
	ResponseEntity<Response<Boolean>> blockFriend(@RequestBody BlockFriendRequest blockFriendRequest) {
		return ResponseEntity
				.ok(new Response<Boolean>(true, Message.OTHER_SUCCESS, friendServic.blockFriend(blockFriendRequest)));
	}

	@Operation(description = "API phản hồi lời mời kết bạn")
	@PostMapping("/reply-friend")
	ResponseEntity<Response<Boolean>> replyFriend(
			@RequestBody ReplyInvitationFriendRequest replyInvitationFriendRequest) {
		return ResponseEntity.ok(new Response<Boolean>(true, Message.OTHER_SUCCESS,
				friendServic.replyFriend(replyInvitationFriendRequest)));
	}

}
