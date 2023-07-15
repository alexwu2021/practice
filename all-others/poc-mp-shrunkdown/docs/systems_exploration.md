talking point: can't do virtualization 


Alex@docmatters-mbp Documents % brew install docker-machine docker
Warning: Treating docker as a formula. For the cask, use homebrew/cask/docker
Warning: docker-machine 0.16.2 is already installed and up-to-date.
To reinstall 0.16.2, run:
brew reinstall docker-machine
Warning: docker 20.10.12 is already installed and up-to-date.
To reinstall 20.10.12, run:
brew reinstall docker
Alex@docmatters-mbp Documents % brew cask install virtualbox
Error: Unknown command: cask
Alex@docmatters-mbp Documents % brew install virtualbox
==> Caveats
virtualbox requires a kernel extension to work.
If the installation fails, retry after you enable it in:
System Preferences → Security & Privacy → General

For more information, refer to vendor documentation or this Apple Technical Note:
https://developer.apple.com/library/content/technotes/tn2459/_index.html

==> Downloading https://download.virtualbox.org/virtualbox/6.1.30/VirtualBox-6.1
######################################################################## 100.0%
Error: Cask virtualbox depends on hardware architecture being one of [{:type=>:intel, :bits=>64}], but you are running {:type=>:arm, :bits=>64}.
 
