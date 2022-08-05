package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 번호 생성 테스트")
    void should_GenerateLottoNumber() {
        //given
        LottoNumberGenerator generator = new LottoNumberGenerator();
        //when
        Set<LottoNumber> lottoNumber = generator.newLottoNumber();
        //then
        assertThatNoException().isThrownBy(generator::newLottoNumber);
        assertThat(generator.newLottoNumber()).isInstanceOf(Set.class);
        assertThat(lottoNumber).isNotEmpty()
                .hasSize(6)
                .doesNotHaveDuplicates();
    }
}