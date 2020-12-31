package com.tts.PositiveVibes.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.tts.PositiveVibes.model.Role;
import com.tts.PositiveVibes.model.Tag;
import com.tts.PositiveVibes.model.User;
import com.tts.PositiveVibes.model.Vibe;
import com.tts.PositiveVibes.model.VibeDisplay;
import com.tts.PositiveVibes.repository.RoleRepository;
import com.tts.PositiveVibes.repository.TagRepository;
import com.tts.PositiveVibes.repository.UserRepository;
import com.tts.PositiveVibes.repository.VibeRepository;


@Service
public class VibeService {

	 @Autowired
	    private VibeRepository vibeRepository;

	    @Autowired
	    private TagRepository tagRepository;

	    public List<Vibe> findAll() {
	        List<Vibe> vibes = vibeRepository.findAllByOrderByCreatedAtDesc();
	        return formatVibes(vibes);
	    }

	    private List<Vibe> formatVibes(List<Vibe> vibes) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Vibe> findAllByUser(User user) {
	        List<Vibe> vibes = vibeRepository.findAllByUserOrderByCreatedAtDesc(user);
	        return vibes;
	    }

	    public List<Vibe> findAllByUsers(List<User> users) {
	        List<Vibe> vibes = vibeRepository.findAllByUserInOrderByCreatedAtDesc(users);
	        return vibes;
	    }

	    public List<Vibe> findAllWithTag(String tag) {
	        List<Vibe> vibes = vibeRepository.findByTags_PhraseOrderByCreatedAtDesc(tag);
	        return formatVibes(vibes);
	    }

	    // public List<Tweet> findAllByFollower(List<User> followers){
	    // List<Tweet> tweets = tweetRepository.findAllBy
	    // return formatTweets(tweets);
	    // }

	    public void save(Vibe vibe) {
	        handleTags(vibe);
	        vibeRepository.save(vibe);
	    }

	    private void handleTags(Vibe vibe) {
	        List<Tag> tags = new ArrayList<Tag>();
	        Pattern pattern = Pattern.compile("#\\w+");
	        Matcher matcher = pattern.matcher(vibe.getMessage());
	        while (matcher.find()) {
	            String phrase = matcher.group().substring(1).toLowerCase();
	            Tag tag = tagRepository.findByPhrase(phrase);
	            if (tag == null) {
	                tag = new Tag();
	                tag.setPhrase(phrase);
	                tagRepository.save(tag);
	            }
	            tags.add(tag);
	        }
	        vibe.setTags(tags);
	    }

	
	    private void addTagLinks(List<Vibe> vibes) {
	        Pattern pattern = Pattern.compile("#\\w+");
	        for (Vibe vibe : vibes) {
	            String message = vibe.getMessage();
	            Matcher matcher = pattern.matcher(message);
	            Set<String> tags = new HashSet<String>();
	            while (matcher.find()) {
	                tags.add(matcher.group());
	            }
	            for (String tag : tags) {
	                message = message.replaceAll(tag,
	                        "<a class=\"tag\" href=\"/tweets/" + tag.substring(1).toLowerCase() + "\">" + tag + "</a>");
	            }
	            vibe.setMessage(message);
	        }
	    }

	    private void shortenLinks(List<Vibe> vibes) {
	        Pattern pattern = Pattern.compile("https?[^ ]+");
	        for (Vibe vibe : vibes) {
	            String message = vibe.getMessage();
	            Matcher matcher = pattern.matcher(message);
	            while (matcher.find()) {
	                String link = matcher.group();
	                String shortenedLink = link;
	                if (link.length() > 23) {
	                    shortenedLink = link.substring(0, 20) + "...";
	                    message = message.replace(link,
	                            "<a class=\"tag\" href=\"" + link + "\" target=\"_blank\">" + shortenedLink + "</a>");
	                }
	                vibe.setMessage(message);
	            }

	        }
	    }

	    

	}