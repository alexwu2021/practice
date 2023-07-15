Entity View Fact Collection

2/2022


visit = view

Entities covered:

-	discussion:
     o	user visits a single discussion page in web app.  
     o	user views a single discussion in mobile app.
-	user
     o	user visits a user profile page in web app.
     o	user views a user profile in mobile app
-	community
     o	user visits a community page.
     o	user views a community in mobile app.

-	webinar
     o	user visits a webinar page.
     o	user views a webinar in mobile app.


Kafka topic payload for an entity view event

properties
-	event_type: "view"
-	uid: NUMBER (ID of the user who visited the entity)
-	user_cid_list: list of NUMBER (list of community cids that the user is member)

-	discussion_thread_id: NUMBER (ID of the discussion, if the entity is a discussion. 0 otherwise)
-	post_id_list: list of NUMBER (list of post IDs in the discussion thread if the entity is a discussion.  Empty otherwise)
-	post_author_list: list of NUMBER (list of user IDs of post authors if the entity is a discussion. Empty otherwise)
-	discussion_cid_list: list of NUMBERS (list of community cids that the discussion is in.  Empty otherwise)
-

-	cid: NUMBER (cid of the community user visited if the entity is a community.  0 otherwise)

-	webinar_id: NUMBER (ID of the webinar if the entity is a webinar, 0 otherwise)

-	profile_user_id: NUMBER (ID of the user if the entity is the user profile, 0 otherwise)


-	view_date: NUMBER (datetime of the view)

-	app: NUMBER (an small int number identifying the src app. 0 = web app, 1=mobile browser, any number greater than 1 identifies mobile apps of different versions)


Metrics we are collecting Below are some examples.

-	how many times a discussion is viewed total overall or in a period?
-	how many times a discussion is viewed by community members overall or in a period?
-	sum of views of all posts (not discussion threads) of an author overall or in a period?
-	sum of views of all posts of an author, by members of a community, overall or in a period?

-	how many times a user viewed an entity of a community of given type in a period or overall?

  
