export interface Post{

  id: number | null
  header:string,
  content:string,
  author:string

  creationTimestamp:string | null
  updateTimestamp:string | null
}
