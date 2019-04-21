import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp(){
        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스","탑");
        Champion jungleChamp = new Champion("리신","정글");
        Champion midChamp = new Champion("르블랑","미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<String>();
        assertThat(emptyList, empty());
    }

    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    @Test
    public void StringCheck() {
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "Focus";
        assertThat(sampleString, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString, is(endsWith(endString)));
    }

    @Test
    public void FloatCheck() {
        // (hamcrest)실값 3.14, 기댓값 3, 오차허용 2
        assertThat(3.14, closeTo(3, 2));
        // (junit)기댓값 3.14, 실값 3, 오차허용 2
        assertEquals(3.14, 3, 2);
    }

    @Test
    public void shouldNotErrorGetReference() {
        // 2가 아닌 5 이상의 값을 참조할 경우에는 에러 발생

        for(int i=0; i<1000; i++)
            assertThat(championList.get(2), anything());
    }


    // 사이즈 5인지 체크
    @Test
    public void shouldChampionCountFive() {
        assertThat(championList.size(), is(5));
        assertThat(championList, Matchers.<Champion>hasSize(5));
    }

    @Test
    public void 서폿챔피언은타릭() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));
    }


    // 포지션 갖고있는지?
    @Test
    public void shouldHasPropertyPosition () {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
    }

    // 챔피언
    @Test
    public void shouldHaveSomeChampName() {
        List<String> championNames;
        championNames = Arrays.asList("루시안", "애쉬");

        assertThat(championNames.get(0), hasToString("루시안"));
        //assertThat(championNames.get(1), hasToString("루시안"));
    }

    @Test
    public void shouldTopChampionIsDarius() {
        Stream<Champion> as = championList.stream();

        Optional<Champion> filteredChampion =
                championList.stream()
                        .filter(c->c.getPosition().equals("탑"))
                        .findFirst();

        String champName = filteredChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }
}