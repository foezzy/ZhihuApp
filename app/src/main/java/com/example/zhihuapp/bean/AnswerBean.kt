package com.example.zhihuapp.bean

data class AnswerBean(
    val `data`: List<Data>,
    val paging: Paging,
    val read_count: Int
)

data class Data(
    val admin_closed_comment: Boolean,
    val annotation_action: Any,
    val answer_type: String,
    val author: AsAuthor,
    val can_comment: CanComment,
    val collapse_reason: String,
    val collapsed_by: String,
    val comment_count: Int,
    val comment_permission: String,
    val content: String,
    val created_time: Int,
    val editable_content: String,
    val excerpt: String,
    val extras: String,
    val id: Long,
    val is_collapsed: Boolean,
    val is_copyable: Boolean,
    val is_labeled: Boolean,
    val is_normal: Boolean,
    val is_sticky: Boolean,
    val mark_infos: List<Any>,
    val question: Question,
    val reaction_instruction: ReactionInstruction,
    val relationship: RelationshipX,
    val relevant_info: RelevantInfo,
    val reshipment_settings: String,
    val reward_info: RewardInfo,
    val settings: Settings,
    val suggest_edit: SuggestEdit,
    val type: String,
    val updated_time: Int,
    val url: String,
    val voteup_count: Int
)

data class Paging(
    val is_end: Boolean,
    val is_start: Boolean,
    val next: String,
    val previous: String,
    val totals: Int
)

data class AsAuthor(
    val avatar_url: String,
    val avatar_url_template: String,
    val badge: List<Badge>,
    val badge_v2: BadgeV2,
    val follower_count: Int,
    val gender: Int,
    val headline: String,
    val id: String,
    val is_advertiser: Boolean,
    val is_followed: Boolean,
    val is_org: Boolean,
    val is_privacy: Boolean,
    val name: String,
    val type: String,
    val url: String,
    val url_token: String,
    val user_type: String,
    val vip_info: VipInfo
)

data class CanComment(
    val reason: String,
    val status: Boolean
)

data class Question(
    val created: Int,
    val id: Int,
    val question_type: String,
    val relationship: Relationship,
    val title: String,
    val type: String,
    val updated_time: Int,
    val url: String
)

data class ReactionInstruction(
    val REACTION_CONTENT_SEGMENT_LIKE: String
)

data class RelationshipX(
    val is_author: Boolean,
    val is_authorized: Boolean,
    val is_nothelp: Boolean,
    val is_thanked: Boolean,
    val upvoted_followees: List<Any>,
    val voting: Int
)

data class RelevantInfo(
    val is_relevant: Boolean,
    val relevant_text: String,
    val relevant_type: String
)

data class RewardInfo(
    val can_open_reward: Boolean,
    val is_rewardable: Boolean,
    val reward_member_count: Int,
    val reward_total_money: Int,
    val tagline: String
)

data class Settings(
    val table_of_contents: TableOfContents
)

data class SuggestEdit(
    val reason: String,
    val status: Boolean,
    val tip: String,
    val title: String,
    val unnormal_details: UnnormalDetails,
    val url: String
)

data class Badge(
    val description: String,
    val topics: List<Topic>,
    val type: String
)

data class BadgeV2(
    val detail_badges: List<DetailBadge>,
    val icon: String,
    val merged_badges: List<MergedBadge>,
    val night_icon: String,
    val title: String
)

data class VipInfo(
    val is_vip: Boolean,
    val vip_icon: VipIcon
)

data class Topic(
    val avatar_url: String,
    val id: String,
    val name: String,
    val topic_type: String,
    val type: String,
    val url: String
)

data class DetailBadge(
    val description: String,
    val detail_type: String,
    val icon: String,
    val night_icon: String,
    val sources: List<Source>,
    val title: String,
    val type: String,
    val url: String
)

data class MergedBadge(
    val description: String,
    val detail_type: String,
    val icon: String,
    val night_icon: String,
    val sources: List<Source>,
    val title: String,
    val type: String,
    val url: String
)

data class Source(
    val avatar_path: String,
    val avatar_url: String,
    val description: String,
    val id: String,
    val name: String,
    val priority: Int,
    val token: String,
    val type: String,
    val url: String
)

data class VipIcon(
    val night_mode_url: String,
    val url: String
)

class Relationship

data class TableOfContents(
    val enabled: Boolean
)

data class UnnormalDetails(
    val description: String,
    val note: String,
    val reason: String,
    val reason_id: Int,
    val status: String
)