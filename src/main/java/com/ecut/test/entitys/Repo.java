package com.ecut.test.entitys;

/**
 * @author Amy
 * @date 2019-07-08 15:49
 * @description:
 */
public class Repo {
    private int id;
    private String node_id;
    private String name;
    private String full_name;
    private boolean privateX;
    private OwnerEntity owner;
    private String html_url;
    private Object description;
    private boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private Object homepage;
    private int size;
    private int stargazers_count;
    private int watchers_count;
    private String language;
    private boolean has_issues;
    private boolean has_project;
    private boolean has_downloads;
    private boolean has_wiki;
    private boolean has_pages;
    private int forks_count;
    private Object mirror_url;
    private boolean archived;
    private boolean disabled;
    private int open_issues_count;
    private int license;
    private int forks;
    private int open_issues;
    private int watchers;
    private String default_branch;

    private static class OwnerEntity {
        private String login;
        private int id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private boolean site_admin;

        @Override
        public String toString() {
            return "OwnerEntity{" +
                    "login='" + login + '\'' +
                    ", id=" + id +
                    ", avatar_url='" + avatar_url + '\'' +
                    ", gravatar_id='" + gravatar_id + '\'' +
                    ", url='" + url + '\'' +
                    ", html_url='" + html_url + '\'' +
                    ", followers_url='" + followers_url + '\'' +
                    ", following_url='" + following_url + '\'' +
                    ", gists_url='" + gists_url + '\'' +
                    ", starred_url='" + starred_url + '\'' +
                    ", subscriptions_url='" + subscriptions_url + '\'' +
                    ", organizations_url='" + organizations_url + '\'' +
                    ", repos_url='" + repos_url + '\'' +
                    ", events_url='" + events_url + '\'' +
                    ", received_events_url='" + received_events_url + '\'' +
                    ", type='" + type + '\'' +
                    ", site_admin=" + site_admin +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", node_id='" + node_id + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", privateX=" + privateX +
                ", owner=" + owner +
                ", html_url='" + html_url + '\'' +
                ", description=" + description +
                ", fork=" + fork +
                ", url='" + url + '\'' +
                ", forks_url='" + forks_url + '\'' +
                ", keys_url='" + keys_url + '\'' +
                ", collaborators_url='" + collaborators_url + '\'' +
                ", teams_url='" + teams_url + '\'' +
                ", hooks_url='" + hooks_url + '\'' +
                ", issue_events_url='" + issue_events_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", assignees_url='" + assignees_url + '\'' +
                ", branches_url='" + branches_url + '\'' +
                ", tags_url='" + tags_url + '\'' +
                ", blobs_url='" + blobs_url + '\'' +
                ", git_tags_url='" + git_tags_url + '\'' +
                ", git_refs_url='" + git_refs_url + '\'' +
                ", trees_url='" + trees_url + '\'' +
                ", statuses_url='" + statuses_url + '\'' +
                ", languages_url='" + languages_url + '\'' +
                ", stargazers_url='" + stargazers_url + '\'' +
                ", contributors_url='" + contributors_url + '\'' +
                ", subscribers_url='" + subscribers_url + '\'' +
                ", subscription_url='" + subscription_url + '\'' +
                ", commits_url='" + commits_url + '\'' +
                ", git_commits_url='" + git_commits_url + '\'' +
                ", comments_url='" + comments_url + '\'' +
                ", issue_comment_url='" + issue_comment_url + '\'' +
                ", contents_url='" + contents_url + '\'' +
                ", compare_url='" + compare_url + '\'' +
                ", merges_url='" + merges_url + '\'' +
                ", archive_url='" + archive_url + '\'' +
                ", downloads_url='" + downloads_url + '\'' +
                ", issues_url='" + issues_url + '\'' +
                ", pulls_url='" + pulls_url + '\'' +
                ", milestones_url='" + milestones_url + '\'' +
                ", notifications_url='" + notifications_url + '\'' +
                ", labels_url='" + labels_url + '\'' +
                ", releases_url='" + releases_url + '\'' +
                ", deployments_url='" + deployments_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", pushed_at='" + pushed_at + '\'' +
                ", git_url='" + git_url + '\'' +
                ", ssh_url='" + ssh_url + '\'' +
                ", clone_url='" + clone_url + '\'' +
                ", svn_url='" + svn_url + '\'' +
                ", homepage=" + homepage +
                ", size=" + size +
                ", stargazers_count=" + stargazers_count +
                ", watchers_count=" + watchers_count +
                ", language='" + language + '\'' +
                ", has_issues=" + has_issues +
                ", has_project=" + has_project +
                ", has_downloads=" + has_downloads +
                ", has_wiki=" + has_wiki +
                ", has_pages=" + has_pages +
                ", forks_count=" + forks_count +
                ", mirror_url=" + mirror_url +
                ", archived=" + archived +
                ", disabled=" + disabled +
                ", open_issues_count=" + open_issues_count +
                ", license=" + license +
                ", forks=" + forks +
                ", open_issues=" + open_issues +
                ", watchers=" + watchers +
                ", default_branch='" + default_branch + '\'' +
                '}';
    }
}
