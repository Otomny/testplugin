package fr.omny.plugin.managers;


import fr.omny.flow.translation.PlayerToLocaleProvider;
import fr.omny.odi.Autowired;
import fr.omny.odi.Component;

@Component
public class UserI18N {

	@Autowired
	UserRepository userRepository;

	@Component
	public PlayerToLocaleProvider localeProvider() {
		return (player) -> {
			var possiblePlayer = this.userRepository.get(player);
			return possiblePlayer.isPresent() ? possiblePlayer.get().getLocale() : "fr";
		};
	}

}
