package com.app.discordbot.events;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {
	public Mono<Void> processCommand(Message eventMessage){
		return Mono.just(eventMessage)
			.filter(message -> message.getAuthor()
					.map(user->!user.isBot())
					.orElse(false))
			.flatMap(Message::getChannel)
			.flatMap(channel -> channel.createMessage(
					"things to do today : \n - write some code, eat food and sleep"))
			.then();
					
		
		
	}
}
//.filter(message -> message.getAuthor()
//		.map(user->!user.isBot())
//		.orElse(false))