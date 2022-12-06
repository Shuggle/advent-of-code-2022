package day04

class Section(private val min: Int, private val max: Int) {
    fun isFullyIncludedIn(section: Section): Boolean {
        return this.min >= section.min && this.max <= section.max
    }

    fun isOverlaps(section: Section): Boolean {
        return this.min in section.min..section.max || this.max in section.min..section.max
    }


}