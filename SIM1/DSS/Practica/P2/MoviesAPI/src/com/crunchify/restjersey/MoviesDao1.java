package com.crunchify.restjersey;
import java.util.HashMap;
import java.util.Map;
import com.crunchify.restjersey.MoviesModel;
public enum MoviesDao1 {
	 instance;
	private Map<String, MoviesModel> contentProvider = new HashMap<>();
	private MoviesDao1() {
	
	
     MoviesModel movi = new MoviesModel("1","THE MULE","In his first performance in six years, Clint Eastwood brings an elegiac gracefulness and good humor—not to mention defiant toughness—to the role of a 90-year-old flower aficionado named Earl who opts to work as a drug runner in The Mule. Eastwood’s lined visage and creaky comportment can’t dull his fiery spirit in this based-on-real-events drama, which finds the Hollywood icon amusingly raging against modernity’s Internet-and-smartphone addictions, even as his down-on-his-luck character grapples with the familial cost of putting personal obsessions above all else. Pursued by Bradley Cooper’s ambitious DEA agent, who’s similarly striving to meet the requirements of a demanding boss (Laurence Fishburne), Eastwood’s protagonist proves another one of his broken-down big-screen warriors. Full of ladies’ man charm and self-deprecating wit, his turn is as assured as his typically efficient direction, which balances suspense and poignancy with aplomb. It’s further confirmation that the legendary filmmaker hasn’t lost his nimble, self-referential touch.",6.5,"https://www.esquire.com/entertainment/movies/g14465325/best-movies-of-2018/");
     contentProvider.put("1", movi);
     movi= new MoviesModel("2","A PRAYER BEFORE DAWN","Thai prisons are best avoided at all costs, and Jean-Stéphane Sauvaire’s adaptation of Billy Moore’s autobiography is disturbing proof of that fact. After a life of selling (and abusing) drugs lands him in the notorious “Bangkok Hilton,” boxer Moore (Joe Cole) struggles to survive a new world for which he’s not prepared. Acts of rape and violence are omnipresent in this ramshackle environment, which Sauvaire dramatizes through blistering handheld cinematography and jarring sound design, replete with Thai dialogue that’s left un-subtitled for maximum disorientation. Tracing Moore’s rocky path from wanton self-destruction to uneasy transcendence, the film is as unsentimental as it is brutal, especially in its pugilistic sequences, which the director shoots with an astounding measure of up-close-and-personal viciousness and an apparent lack of choreography, as combatants wail on each other with reckless abandon. Cole’s go-for-broke performance as this out-of-control man—all crazy-eyed desolation and battering-ram physicality—is the stuff that turns actors into stars.",8,"https://www.esquire.com/entertainment/movies/g14465325/best-movies-of-2018/");
     contentProvider.put("2", movi);
     
     movi = new MoviesModel("3","PADDINGTON 2","A superior slice of children’s entertainment, Paul King’s sequel to 2015’s Paddington is a sheer joy, infused with comic inspiration and irresistible sweetness. In this second series installment based on the stories of author Michael Bond, the perpetually hatted Paddington (voiced by Ben Wishaw) winds up in prison after he’s framed for the theft of an elaborate pop-up book that he planned to purchase for his dear Aunt Lucy (Imelda Staunton)—a crime that’s actually been perpetrated by a faded local actor (and master of disguise) played, to cartoonish perfection, by Hugh Grant. The set pieces are uniformly inventive, the hybrid live-action/CGI aesthetics are superb, and the supporting cast—including Sally Hawkins, Brendan Gleeson, Julie Walters, Jim Broadbent, and Peter Capaldi—is across-the-board fantastic. Only the hardest of hearts could resist its good-natured charm, epitomized by its sincere belief (advocated by Paddington himself) that the key to improving the world (and ourselves) is compassion, affection, politeness, and positivity",5,"https://www.esquire.com/entertainment/movies/g14465325/best-movies-of-2018/");
     contentProvider.put("3", movi);
	}
	public Map<String, MoviesModel> getModel(){
        return contentProvider;
    }
}
