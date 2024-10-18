package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 역슬레쉬_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 슬레쉬_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("///\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void n_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//n\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 물음표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//?\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_비어있음() {
        assertSimpleTest(() -> {
            run("//\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1-"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
