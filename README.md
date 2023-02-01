[![AGPL-3.0 License][license-shield]][license-url]

<br />
<p align="center">
  <a href="https://gitlab.com/2009scape/2009scape">
    <img src="https://i.imgur.com/RsfVfkB.png" alt="Logo" width="300" height="67">
  </a>
  <h3 align="center">An open source MMORPG emulation server</h3>

  <h1 align="center"><a href="https://2009scape.org/"><strong>Play the live server »</strong></a></h1>
  <p align="center">
    <br />
    <br />
    <a href="https://2009scape.org/">Community Hosted Server</a>
    ·
    <a href="https://discord.gg/43YPGND">Discord Invite</a>
    ·    <a href="https://gitlab.com/2009scape/2009scape/-/issues">Report Bug</a>
  </p>

## Charlotte Edit

This repo contains a couple of edits not neccessary for the live server but for those who wish to host their own private server.

Please do not report bugs to the original developers regarding code I've modified.

Unlike the original developers, I will accept pull requests that add/change features that aren't in line with the 2009 themed nature of the project, so long as they are in the ethos of runescape. For example, adding a feature that OSRS implements would be accepted. Changing Lumbridge castle the have a backdoor is another example of a change I would accept. Furthermore, because this repo is more about the private server side of things, adding in commands to cheat is totally ok, as it's up to the users whether or not they want to use said cheats.

## Changes Made

- Removed heartbeat. This caused crashes when it failed, and private servers don't need a heartbeat.
- Workaround fix for the server crashing when 2 bots interacting with the Grand Exchange at the same time. 
- Changed the "to" command to "tp"
- Increased bank space to 800
- Added server command "say" to send message to all players on server (untested on multiple worlds)
- Removed rules (may add this back in with a config file for those wanting to run a public server)
- Removed daily account limit (so you can LAN with more than 3 people and also allow people running on the same VPN to connect to public servers). 

## Table of Contents

* [Live Server Information](#live-server-information)
* [History of this Codebase](#history-of-this-codebase)
* [Our Core Values](#our-core-values) 
* [Contributing](#contributing)
* [Setup for Content Developers](#content-developers-setting-up-the-project)
  * [Prerequisites](#prerequisites)
  * [Running the project](#running-the-project)
* [License](#license)
* [Contact](#contact)


## Live Server Information

Did you know that the 2009Scape Development Team hosts the main branch of this repo that you can connect to and play? Come join a growing community of people that love to grind out skills, quest, and hangout together. A download link for the launcher can be found [here](https://2009scape.org). Connecting to the live server is also one of the easiest ways to identify bugs/typos/missing features. Identifying these issues help developers, whether already on the project, or are even brand new to the project, fix bugs and issues in an expedited rate.

## History of this Codebase

The 2009Scape you see today has gone through a magnitude of changes. Originally starting its life as Arios498, this server saw a lot of people playing it daily, unfortunately, it was for profit and closed source. It was later upgraded to Arios530, targeting the build 530 of runescape with content in and around January 1st, 2009. Development came to a halt when a developer of the closed source project released the source code. The original developers of this server went on to create Kratos 530 back in 2015.

This project was started out of love for the 530 revision. A small group of developers spent thousands of hours improving on the existing source that was left to the curb. Over the past year, this project has seen many developers coming and going, fixing bugs that they find either through their own server, or bugs that they find in the live game that is currently hosted. We do not accept donations of any kind. The smiles and wonderful compliments are more than enough to keep us going! Content and bugfixes are always number one on our list, and we try our best to answer any questions that you may have, provided you have read through this readme and frequently asked questions on the discord.

## Our Core Values

In the current climate of RuneScape Private Servers in general, we believe it's important to wear our core values on our sleeves and defend them with everything we have! Below are what we hold as our core, most important values:

* **We do NOT believe in profiting off an RSPS.** To many of us here at the 2009Scape team, what we care about most is preserving the wonderful work of the Gower brothers in the most true-to-spirit manner possible. We do NOT do this to make a profit, and in fact **we outright refuse donations.** This is a labor of love and passion for everyone involved, a love for real RS2! This is perhaps the single most central value we have. If you want to "donate" to us, do so with your time and your dedication. That is what we desire most.
  

* **Authenticity is central to the work**. As a remake, one of the most important things to us is being true to the Gower spirit. What the Gowers brought to us in our childhood is what we are driven to preserve for the remainder of the world. 


* **Open Source is crucial to the project**. We believe open source remakes to be crucial to preserving what we loved in our childhood, and we believe for-profit and/or closed-source servers are destined to flounder out and fail. 


* **Be welcoming**. One of our most important goals is to provide a community of friendly and caring people that get along and love to enjoy the game with eachother. For this reason, we do tend to be very strict when it comes to toxicity. We care about quality a whole lot more than quantity! 

## Contributing

Contributions can be made in the form of a bug report, as long as it's my code that's broke and not the original developers. For that, please report it to them.

Contributions also include pull requests. Unlike the original developers, I not only accept but welcome both Java and Kotlin code. 

## Content Developers: Setting Up the Project.

### Prerequisites

* Java SE Development Kit Version 11 - Whilst you can run the server with another version, only 11 works for saving player data as far as I've tested.

### Running the project

#### Linux / OSX

Should be as simple as cloning the repository and running `build -g -m`. To build without tests, append the `-q` argument.

Start the game server with the included run script. Use `./run -h` for more info.

#### Windows

Start the game server with `run-server.bat`

Please note that for this repo, Windows support is community orientated as I do not have a Windows device.

### License

We use the AGPL 3.0 license, which can be found [here](https://www.gnu.org/licenses/agpl-3.0.en.html). Please be sure to read and understand the license. Failure to follow the guidelines outlined in the license will result in legal action. If you know or hear of anyone breaking this license, please send a report, with proof, to Red Bracket#8151, ceikry#2724, or woahscam#8535 on discord or email woahscam@hotmail.com. **We WILL NOT change the license to fit your needs.**

### Contact

**Reminder: There is no official support for setting up your own server. Do not ping/dm developers, or ask in support channels about setting up your server. Support for the live server and 2009Scape single-player is available in the Discord.**


[license-shield]: https://img.shields.io/badge/license-AGPL--3.0-informational
[license-url]: https://www.gnu.org/licenses/agpl-3.0.en.html

### Why become a tester?

Before content hits Live, it has to be tested. We can, but do not want to do this alone, and would love the help! But don't worry, there is something in it for you. Credits! Keep in mind that credits will only be awarded to people who thoroughly test the content and provide detailed reports on them. Like votes or HoF you must claim them in the #claim-to-fame channel on discord or matrix.

* If you test smaller things like bug fixes there is a 2 credit reward.
* If you test full quests or minigames you will be rewarded 5 credits.
* If you find a bug in the content you are testing that hasn't already been found you will earn an extra credit.

These credits can be spent in the 2009Scape Reward Shop. It's important to be clear that credits are gained by contributions to the project. We cannot and will not accept donations (of any kind), especially not in exchange for in-game credits or perks.

Testers are not the only people who can gain credits - other ways of earning credits can be found on [the 2009Scape website](https://2009scape.org/site/game_guide/credits.html).

Please be patient! The Credit system is not fully complete yet, so it will take a long time for credits to be awarded. 
