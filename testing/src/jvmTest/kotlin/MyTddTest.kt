import com.crowdproj.rating.testing.domain.RatingObj
import com.crowdproj.rating.testing.port.CreateRating
import com.crowdproj.rating.testing.port.CrudsRating
import com.crowdproj.rating.testing.repository.RatingRepositoryImpl
import com.crowdproj.rating.testing.service.RatingService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  17.02.2023 09:34
 */

class MyTddTest {
    private val nameObjectForRating = "product"
    private val numberSuffix: Int = 5
    private val count: Int = 10
    private val ratingObj: RatingObj = RatingObj(nameObjectForRating)
    private val createRating: CreateRating
    private val crudsRating: CrudsRating

    init {
        val ratingService = RatingService(RatingRepositoryImpl())
        createRating = ratingService
        crudsRating = ratingService
    }

    @BeforeEach
    fun initEach() {
        if (crudsRating.getAll().isEmpty()) {
            val list = List<RatingObj>(count) { RatingObj(nameObjectForRating = "product$it") }
            list.forEach { crudsRating.save(it) }
        }
    }

    @Test
    fun `Given object to score, When create rating, Then new rating`() {
        assertNotNull(createRating.create { it.ratingObj = ratingObj })
    }

    @Test
    fun `Given rating, When save rating to db, Then expect true`() {
        assertTrue { crudsRating.save(ratingObj) }
    }

    @Test
    fun `Given ratings, When look at all ratings, Then expect ratings list`() {
        assertEquals(count, crudsRating.getAll().size)
    }

    @Test
    fun `Given ratings, When find the rating, Then expect rating`() {
        val expected: String = "product$numberSuffix"
        val actual: String = crudsRating.findByName(nameObjectForRating = "product$numberSuffix").ratingObj?.getName().toString()
        assertEquals(expected, actual)
    }

    @Test
    fun `Given ratings, When delete the rating, Then expect true`() {
        val ratingObj = RatingObj(nameObjectForRating = "product$numberSuffix")
        assertTrue { crudsRating.delete(ratingObj) }
    }

    @Test
    fun `Given ratings, When updated the rating, Then expect rating with new data`() {
        val currentNameObjectForRating: String =  nameObjectForRating + numberSuffix
        val newNameObjectForRating: String = "service$numberSuffix"
        assertTrue(crudsRating.update(currentNameObjectForRating, newNameObjectForRating))
    }
}