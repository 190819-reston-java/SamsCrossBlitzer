export interface GeneralNewsInterface {
    data?: (DataEntity)[] | null;
  }
  export interface DataEntity {
    title: string;
    news_url: string;
    image_url: string;
    text: string;
    sentiment: string;
    type: string;
    source_name: string;
    date: string;
    topics?: (null)[] | null;
  }
  